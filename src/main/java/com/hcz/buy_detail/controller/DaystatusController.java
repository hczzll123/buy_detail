package com.hcz.buy_detail.controller;


import com.hcz.buy_detail.entity.Buydetails;
import com.hcz.buy_detail.entity.Daystatus;
import com.hcz.buy_detail.service.BuydetailsService;
import com.hcz.buy_detail.service.DaystatusService;
import com.hcz.buy_detail.utils.UnzipUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hechangzheng
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/daystatus")
public class DaystatusController {

    @Autowired
    DaystatusService daystatusService;

    @Autowired
    BuydetailsService buydetailsService;


    //查询出所有的excel并将数据持久化
    public void find(String path, String reg) {
        Pattern pat = Pattern.compile(reg);
        File file = new File(path);
        File[] arr = file.listFiles();
        for (int i = 0; i < arr.length; i++) {
            //判断是否是文件夹，如果是的话，再调用一下find方法
            if (arr[i].isDirectory()) {
                find(arr[i].getAbsolutePath(), reg);
            }
            Matcher mat = pat.matcher(arr[i].getAbsolutePath());
            //根据正则表达式，寻找匹配的文件
            if (mat.matches()) {
                //这个getAbsolutePath()方法返回一个String的文件绝对路径
                System.out.println(arr[i].getAbsolutePath());
                List<Buydetails> buydetailsList = end(arr[i].getAbsolutePath());
                buydetailsService.saveBatch(buydetailsList);

                System.out.println("-----------------------------");

            }
        }
    }


    //此方法用于解析压缩包文件
    @RequestMapping("/analysis")
    public String analysis(String soueseFile, ModelMap map) {

        StringBuilder string = new StringBuilder(soueseFile);

        string.replace(4, 5, "");
        string.replace(6, 7, "");
        string.append(".zip");
        String str = "C:/Users/Administrator/Desktop/";
        str = str + string.toString();


        //解压并返回了解压后的文件名称
        String soursefile = unZipBox(str);


        File file = new File(soursefile);

        //删除原有数据
        String dayname = file.getName();
        StringBuilder stringBuilder = new StringBuilder(dayname);

        stringBuilder.insert(4, "-");
        stringBuilder.insert(7, "-");
        dayname = stringBuilder.toString();

        buydetailsService.deleteOldData(dayname);


        //查询出解压后文件中所有的excel并将数据持久化
        find(soursefile, "\\S+\\.xls");

        //删除解压文件
        deleteFile(file);


        //维护该天的状态

        Daystatus daystatus = new Daystatus();
        daystatus.setDate(dayname).setStatus("已解析");
        daystatusService.updateStatus(daystatus);


        return "解析成功";
    }


    //此方法用于删除解压后的目录
    private void deleteFile(File file) {
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()) {
            System.out.println("文件删除失败,请检查文件路径是否正确");
            return;
        }
        //取得这个目录下的所有子文件对象
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        for (File f : files) {
            //打印文件名
            String name = file.getName();
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()) {
                deleteFile(f);
            } else {
                f.delete();
            }
        }
        //删除空文件夹  for循环已经把上一层节点的目录清空。
        file.delete();
    }


    //此方法用于解压文件
    private String unZipBox(String filesourse) {


        File filesrc = new File(filesourse);

        if (filesrc.isDirectory()) {
            File[] files = filesrc.listFiles();


            if (files == null || files.length == 0) {
                return null;
            }

            for (File fil : files) {


                //如果是目录则递归调用  依次解压文件中的所有zip
                unZipBox(fil.getAbsolutePath());

            }

        } else {
            //不属于目录的情况下，判断文件是否以.zip结尾，若是的则解压

            String absolutePath = filesrc.getAbsolutePath();

            String destDirPath = "";

            String[] split = absolutePath.split("\\.");
            if (split[split.length - 1].equals("zip")) {
                destDirPath = absolutePath.substring(0, absolutePath.lastIndexOf("."));

                UnzipUtils.unZip(filesrc, destDirPath);

                //递归去解压解压后的文件里的.zip文件
                unZipBox(destDirPath);


            }


        }


        String soursefile = filesrc.getAbsolutePath();

        String[] split = soursefile.split("\\.");


        return split[0];


    }


    //此方法为了找到该excel中所需数据的所在行号
    private List<Integer> testexcel(String absolutePath) {

        //    int kaishi = 0;
        //    int jiesu = 0;

        ArrayList<Integer> list = new ArrayList<>();

        try (FileInputStream is = new FileInputStream(absolutePath)) {

            HSSFWorkbook workbook = new HSSFWorkbook(is);

            int numberOfSheets = workbook.getNumberOfSheets();

            for (int i = 0; i < numberOfSheets; i++) {

                //获取到单个sheet
                HSSFSheet singleSheet = workbook.getSheetAt(i);

                //该sheet一共有多少行
                int lastRowNum = singleSheet.getLastRowNum();

                for (int rownum = singleSheet.getFirstRowNum(); rownum <= lastRowNum; rownum++) {

                    //5.获取单行记录
                    Row singleRow = singleSheet.getRow(rownum);

                    //6.该行到底有多少列
                    short lastCellNum1 = singleRow.getLastCellNum();

                    Buydetails buy = new Buydetails();
                    for (short cellNum = singleRow.getFirstCellNum(); cellNum < lastCellNum1; cellNum++) {

                        //7.获取单个列
                        Cell singleCell = singleRow.getCell(cellNum);

                        if (singleCell == null) {

                            continue;
                        }

                        if (singleCell.getStringCellValue().contains("终端号")) {

                            list.add(rownum);

                        }

                        if (singleCell.getStringCellValue().contains("POS编号")) {
                            list.add(rownum);

                        }


                    }


                }


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;


    }


    //此方法为了找到该excel中的数据并进行封装
    private List<Buydetails> end(String sourse) {

        List<Integer> list = testexcel(sourse);


        ArrayList<Buydetails> beanlist = new ArrayList<>();

        try {
            FileInputStream is = new FileInputStream(sourse);


            HSSFWorkbook workbook = null;
            try {
                workbook = new HSSFWorkbook(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int numberOfSheets = workbook.getNumberOfSheets();

            for (int i = 0; i < numberOfSheets; i++) {

                //获取到单个sheet
                HSSFSheet singleSheet = workbook.getSheetAt(i);

                for (int j = list.get(0) + 1; j < list.get(1); j++) {

                    //5.获取单行记录
                    Row singleRow = singleSheet.getRow(j);

                    Buydetails buycart = new Buydetails();


                    //6.该行到底有多少列
                    short lastCellNum1 = singleRow.getLastCellNum();

                    Buydetails buy = new Buydetails();
                    for (short cellNum = singleRow.getFirstCellNum(); cellNum < lastCellNum1; cellNum++) {

                        //7.获取单个列
                        Cell singleCell = singleRow.getCell(cellNum);

                        if (singleCell == null) {

                            continue;
                        }

                        if (cellNum == 2) {
                            buycart.setEndId(Integer.valueOf(singleCell.getStringCellValue()));
                        }

                        if (cellNum == 4) {
                            buycart.setBankAdress(singleCell.getStringCellValue());
                        }
                        if (cellNum == 8) {
                            buycart.setCartType(singleCell.getStringCellValue());

                        }

                        if (cellNum == 10) {
                            buycart.setCartAcct(singleCell.getStringCellValue());

                        }

                        if (cellNum == 12) {
                            buycart.setTradeDay(singleCell.getStringCellValue());

                        }

                        if (cellNum == 13) {
                            buycart.setTradeTime(singleCell.getStringCellValue());

                        }
                        if (cellNum == 14) {
                            buycart.setPayType(singleCell.getStringCellValue());

                        }
                        if (cellNum == 16) {
                            buycart.setAuthAcct(singleCell.getStringCellValue());

                        }
                        if (cellNum == 17) {
                            buycart.setPayAcct(new BigDecimal(singleCell.getStringCellValue()));
                        }

                        if (cellNum == 18) {
                            buycart.setSmallMoney(new BigDecimal(singleCell.getStringCellValue()));

                        }

                        if (cellNum == 19) {
                            buycart.setStage(singleCell.getStringCellValue());

                        }
                        if (cellNum == 20) {
                            buycart.setHandleMoney(new BigDecimal(singleCell.getStringCellValue()));

                        }

                        if (cellNum == 21) {
                            buycart.setDccBackmoney(new BigDecimal(singleCell.getStringCellValue()));

                        }
                        if (cellNum == 22) {
                            buycart.setPaymentMoney(new BigDecimal(singleCell.getStringCellValue()));

                        }

                        if (cellNum == 23) {
                            buycart.setTradeNum(singleCell.getStringCellValue());

                        }
                        if (cellNum == 24) {
                            buycart.setBatchNum(singleCell.getStringCellValue());

                        }

                        if (cellNum == 26) {
                            buycart.setSaleAcct(singleCell.getStringCellValue());

                        }

                        if (cellNum == 27) {
                            buycart.setOrderAcct(singleCell.getStringCellValue());

                        }
                        if (cellNum == 30) {
                            buycart.setSystemAcct(singleCell.getStringCellValue());

                        }
                        if (cellNum == 31) {
                            buycart.setCartName(singleCell.getStringCellValue());

                        }

                        if (cellNum == 32) {
                            buycart.setPayTradenum(singleCell.getStringCellValue());

                        }
                        if (cellNum == 33) {
                            buycart.setRemarkNum1(singleCell.getStringCellValue());

                        }

                        if (cellNum == 34) {
                            buycart.setRemarkNum2(singleCell.getStringCellValue());

                        }


                    }
                    beanlist.add(buycart);


                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // System.out.println(beanlist);

        return beanlist;


    }


}

