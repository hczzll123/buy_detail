package com.hcz.buy_detail.controller;



import com.hcz.buy_detail.entity.TAdmin;
import com.hcz.buy_detail.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    TAdminService tAdminService;

    @RequestMapping("add")
    @ResponseBody
    public String addAdmin(){

        TAdmin tAdmin = new TAdmin();
        tAdmin.setLoginAcct("hcz").setUserPswd("Aa888888").setUserName("何昌政").setEmail("hcz@qq.com").setCreateTime("20200414");
        tAdminService.save(tAdmin);

        return "成功";
    }



}

