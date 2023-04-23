//package com.hcz.buy_detail;
//
//
//import com.hcz.buy_detail.entity.Buydetails;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Dragon-king
// * @createdate 2020/6/10 - 11:39
// */
//public class TestPoi {
//
//
//    @Test
//    public void testString(){
//        String s = "2020-06-08";
//        StringBuilder string = new StringBuilder(s);
//
//        string.replace(4,5,"");
//        string.replace(6,7,"");
//        string.append(".zip");
//        String str = "C:/Users/Administrator/Desktop/";
//        str = str+string.toString();
//
//        System.out.println(str);
//
//
//    }
//
//
//
//
//
//    public static void testunzip(String filesourse) {
//
//        File filesrc = new File(filesourse);
//
//
//        if (filesrc.isDirectory()) {
//            File[] files = filesrc.listFiles();
//
//
//            if (files == null || files.length == 0) {
//                return ;
//            }
//
//            for (File fil : files) {
//
//                System.out.println(fil.getAbsolutePath());
//
//                //如果是目录则递归调用  依次解压文件中的所有zip
//                testunzip(fil.getAbsolutePath());
//
//            }
//
//        } else {
//            //不属于目录的情况下，判断文件是否以.zip结尾，若是的则解压
//
//            String absolutePath = filesrc.getAbsolutePath();
//
//            String destDirPath = "";
//
//            String[] split = absolutePath.split("\\.");
//            if (split[split.length - 1].equals("zip")) {
//                destDirPath = absolutePath.substring(0, absolutePath.lastIndexOf("."));
//
//                System.out.println(destDirPath+"正在解压");
//                UnzipUtils.unZip(filesrc, destDirPath);
//                System.out.println(destDirPath+"解压完成");
//
//                //递归去解压解压后的文件里的.zip文件
//                testunzip(destDirPath);
//
//
//            }
//
//
//
//        }
//
//
//    }
//
//
//    @Test
//    public void unzipFile() {
//
//        File file = new File("C:/Users/Administrator/Desktop/20200608.zip");
//
//        testunzip(file.getAbsolutePath());
//
//    }
//
//
//    @Test
//    public void testPoi(){
//
//        String sourseFile = "C:/Users/Administrator/Desktop/20200608";
//
//        printAcount(sourseFile);
//
//    }
//
//    public static void printAcount(String sourceFile){
//
//        File file = new File(sourceFile);
//
//
//        if(file.isDirectory()){
//
//            File[] files = file.listFiles();
//
//            if (files == null || files.length == 0) {
//                return ;
//            }
//
//
//            for (File file1 : files) {
//
//                printAcount(file1.getAbsolutePath());
//            }
//
//
//        }else {
//
//            String absolutePath = file.getAbsolutePath();
//
//            String[] split = absolutePath.split("\\.");
//
//            if (split[split.length - 1].equals("xls")) {
//
//                //拿到所有的.xls结尾的文件，解析excel表格，将终端交易数据持久化
//                System.out.println("-----------------------------------------------------------");
//                System.out.println(absolutePath);
//
//
//                try(FileInputStream is = new FileInputStream(absolutePath)) {
//
//                    HSSFWorkbook workbook = new HSSFWorkbook(is);
//
//                    int numberOfSheets = workbook.getNumberOfSheets();
//
//                    for (int i = 0; i < numberOfSheets ; i++) {
//
//                        //获取到单个sheet
//                        HSSFSheet singleSheet = workbook.getSheetAt(i);
//
//                        //该sheet一共有多少行
//                        int lastRowNum = singleSheet.getLastRowNum();
//
//                        for (int rownum = singleSheet.getFirstRowNum(); rownum <= lastRowNum; rownum++) {
//
//                            //5.获取单行记录
//                            Row singleRow = singleSheet.getRow(rownum);
//
//                            Buydetails buycart = new Buydetails();
//
//                            //6.该行到底有多少列
//                            short lastCellNum = singleRow.getLastCellNum();
//                            for (short cellNum = singleRow.getFirstCellNum(); cellNum <lastCellNum; cellNum++) {
//
//                                //7.获取单个列
//                               Cell singleCell = singleRow.getCell(cellNum);
//
//                                if(singleCell == null){
//
//                                   continue;
//                               }
//
//
//
//                                System.out.println(singleCell.getStringCellValue()+"--当前列是"+cellNum+"当前行是"+rownum);
//
//
//                            }
//
//
//                        }
//
//
//
//
//                    }
//
//
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//
//        }
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    //终于设置进去
//
//
//    //此方法为了找到该exceld的数据所在行
//    public List<Integer> testexcel(String absolutePath){
//
//    //    int kaishi = 0;
//    //    int jiesu = 0;
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        try(FileInputStream is = new FileInputStream(absolutePath)) {
//
//            HSSFWorkbook workbook = new HSSFWorkbook(is);
//
//            int numberOfSheets = workbook.getNumberOfSheets();
//
//            for (int i = 0; i < numberOfSheets; i++) {
//
//                //获取到单个sheet
//                HSSFSheet singleSheet = workbook.getSheetAt(i);
//
//                //该sheet一共有多少行
//                int lastRowNum = singleSheet.getLastRowNum();
//
//                for (int rownum = singleSheet.getFirstRowNum(); rownum <= lastRowNum; rownum++) {
//
//                    //5.获取单行记录
//                    Row singleRow = singleSheet.getRow(rownum);
//
//                    //6.该行到底有多少列
//                    short lastCellNum1 = singleRow.getLastCellNum();
//
//                    Buydetails buy =  new Buydetails();
//                    for (short cellNum = singleRow.getFirstCellNum(); cellNum <lastCellNum1; cellNum++) {
//
//                        //7.获取单个列
//                        Cell singleCell = singleRow.getCell(cellNum);
//
//                        if (singleCell == null) {
//
//                            continue;
//                        }
//
//                        if(singleCell.getStringCellValue().contains("终端号")){
//
//                            list.add(rownum);
//
//
//                        }
//
//                        if(singleCell.getStringCellValue().contains("POS编号")){
//                            list.add(rownum);
//
//                        }
//
//
//                    }
//
//
//
//                }
//
//
//
//
//            }
//
//
//
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return list;
//
//
//    }
//
//
//    @Test
//    public void end(){
//
//        String sourse = "C:/Users/Administrator/Desktop/20200608/20200608/SHOP.105000056991905.20200608/SHOP.105000056991905.20200608.02.success.xls";
//
//        List<Integer> list = testexcel(sourse);
//
//
//
//        ArrayList<Buydetails> beanlist = new ArrayList<>();
//
//        try {
//            FileInputStream is = new FileInputStream(sourse);
//
//
//            HSSFWorkbook workbook = null;
//            try {
//                workbook = new HSSFWorkbook(is);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            int numberOfSheets = workbook.getNumberOfSheets();
//
//            for (int i = 0; i < numberOfSheets; i++) {
//
//                //获取到单个sheet
//                HSSFSheet singleSheet = workbook.getSheetAt(i);
//
//                for (int j = list.get(0)+1; j <list.get(1) ; j++) {
//
//                    //5.获取单行记录
//                    Row singleRow = singleSheet.getRow(j);
//
//                   Buydetails buycart = new Buydetails();
//
//
//                    //6.该行到底有多少列
//                    short lastCellNum1 = singleRow.getLastCellNum();
//
//                    Buydetails buy =  new Buydetails();
//                    for (short cellNum = singleRow.getFirstCellNum(); cellNum <lastCellNum1; cellNum++) {
//
//                        //7.获取单个列
//                        Cell singleCell = singleRow.getCell(cellNum);
//
//                        if (singleCell == null) {
//
//                            continue;
//                        }
//
//                                      if(cellNum == 2){
//                                                buycart.setEndId(Integer.valueOf(singleCell.getStringCellValue()));
//                                            }
//
//                                            if(cellNum == 4){
//                                                buycart.setBankAdress(singleCell.getStringCellValue());
//                                            }
//                                            if(cellNum == 8){
//                                                buycart.setCartType(singleCell.getStringCellValue());
//
//                                            }
//
//                                            if(cellNum == 10){
//                                                buycart.setCartAcct(singleCell.getStringCellValue());
//
//                                            }
//
//                                            if(cellNum == 12){
//                                                buycart.setTradeDay(singleCell.getStringCellValue());
//
//                                            }
//
//                        if(cellNum == 13){
//                            buycart.setTradeTime(singleCell.getStringCellValue());
//
//                        }
//                        if(cellNum == 14){
//                            buycart.setPayType(singleCell.getStringCellValue());
//
//                        }
//                        if(cellNum == 16){
//                            buycart.setAuthAcct(singleCell.getStringCellValue());
//
//                        }
//                        if(cellNum == 17){
//                            buycart.setPayAcct(new BigDecimal(singleCell.getStringCellValue()));
//                        }
//
//                        if(cellNum == 18){
//                            buycart.setSmallMoney(new BigDecimal(singleCell.getStringCellValue()));
//
//                        }
//
//                        if(cellNum == 19){
//                           buycart.setStage(singleCell.getStringCellValue());
//
//                        }
//                        if(cellNum == 20){
//                            buycart.setHandleMoney(new BigDecimal(singleCell.getStringCellValue()));
//
//                        }
//
//                        if(cellNum == 21){
//                            buycart.setDccBackmoney(new BigDecimal(singleCell.getStringCellValue()));
//
//                        }
//                        if(cellNum == 22){
//                            buycart.setPaymentMoney(new BigDecimal(singleCell.getStringCellValue()));
//
//                        }
//
//                        if(cellNum == 23){
//                            buycart.setTradeNum(singleCell.getStringCellValue());
//
//                        }
//                        if(cellNum == 24){
//                            buycart.setBatchNum(singleCell.getStringCellValue());
//
//                        }
//
//                        if(cellNum == 26){
//                            buycart.setSaleAcct(singleCell.getStringCellValue());
//
//                        }
//
//                        if(cellNum == 27){
//                            buycart.setOrderAcct(singleCell.getStringCellValue());
//
//                        }
//                        if(cellNum == 30){
//                            buycart.setSystemAcct(singleCell.getStringCellValue());
//
//                        }
//                        if(cellNum == 31){
//                            buycart.setCartName(singleCell.getStringCellValue());
//
//                        }
//
//                        if(cellNum == 32){
//                            buycart.setPayTradenum(singleCell.getStringCellValue());
//
//                        }
//                        if(cellNum == 33){
//                            buycart.setRemarkNum1(singleCell.getStringCellValue());
//
//                        }
//
//                        if(cellNum == 34){
//                            buycart.setRemarkNum2(singleCell.getStringCellValue());
//
//                        }
//
//
//
//                    }
//                    beanlist.add(buycart);
//
//
//
//                }
//
//
//
//
//
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(beanlist);
//
//
//
//
//
//    }
//
//
//
//
//
//}
