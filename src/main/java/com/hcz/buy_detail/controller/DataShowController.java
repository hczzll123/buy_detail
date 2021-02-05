package com.hcz.buy_detail.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hcz.buy_detail.entity.Buydetails;
import com.hcz.buy_detail.entity.Daystatus;
import com.hcz.buy_detail.service.BuydetailsService;
import com.hcz.buy_detail.service.DaystatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Dragon-king
 * @createdate 2020/6/11 - 16:15
 */
@Controller
public class DataShowController {

    @Autowired
    DaystatusService daystatusService;


    @Autowired
    BuydetailsService buydetailsService;

    @RequestMapping("/show")
    public String showData(ModelMap map){

        List<Buydetails> list = buydetailsService.getAllData();

        map.put("list",list);
        System.out.println(list);

        return "buydetail";

    }


    @RequestMapping("/testmsg")
    @ResponseBody
    public String testmsg(ModelMap map){

        JSONObject json = new JSONObject();
        try {
            json.put("name","hcz");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();

    }




    //该方法用于展示每日的状态
    @RequestMapping("/showStatu")
    public String shouStatu(ModelMap map){

        List<Daystatus> daystatuses = daystatusService.selectAll();

        map.put("daystatuses",daystatuses);

        return "status";
    }

    //
    @RequestMapping("/list")
    @ResponseBody
    public String shouState(ModelMap map){
        return "hello";
    }

    //该方法用于搜索和分页的功能
    @RequestMapping("/show/data")
    public String showDayData(String name,
                              @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize",defaultValue = "5")  Integer pageSize,
                              @RequestParam(value = "keyword",defaultValue = "")String keyword,
                              ModelMap map){


        Page<Buydetails> buydetailsPage = new Page<>(pageNum,pageSize);

        QueryWrapper<Buydetails> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("trade_day",name);

        queryWrapper.like("cart_acct",keyword);

        IPage<Buydetails> page = buydetailsService.page(buydetailsPage, queryWrapper);


        map.put("page",page);
        map.put("dayname",name);
        map.put("keyword",keyword);

        return "buydetail";
    }

    //此方法用于删除单条数据
    @RequestMapping("remove/{pageNum}/{dayname}/{keyword}/{id}")
    public String removeBuydetail(
            @PathVariable("pageNum") Integer pageNum,
            @PathVariable("dayname") String dayname,
            @PathVariable("keyword") String keyword,
            @PathVariable("id") Integer id,
            @RequestParam(value = "pageSize",defaultValue = "5")  Integer pageSize
    ){

        buydetailsService.romoveById(id);

        return "redirect:/show/data?pageNum="+pageNum+"&keyword="+keyword+"&name="+dayname;

    }





}
