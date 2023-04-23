package com.hcz.buy_detail.controller;



import com.hcz.buy_detail.config.RetVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hechangzheng
 * @since 2020-11-06
 */
@RestController
@RequestMapping("/t-admin")
public class TAdminController {


    @GetMapping("/welcome")
    public RetVal welcome(){

//        String myName = (String) redisUtil.get("myName");
        return RetVal.successWithData("查询成功",null);
    }

    @RequestMapping("add")
    @ResponseBody
    public RetVal addAdmin(){

//        List<TAdmin> list = tAdminService.list(null);

//        for (TAdmin tAdmin1 : list) {
//            String createTime = tAdmin1.getCreateTime();
//            System.out.println(createTime);
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("name","hcz");
//        map.put("list",list);

        return RetVal.successWithData("成功",null);
    }



}

