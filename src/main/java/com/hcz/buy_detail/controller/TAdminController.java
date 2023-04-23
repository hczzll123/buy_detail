package com.hcz.buy_detail.controller;



import com.hcz.buy_detail.config.RetVal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @GetMapping("/welcome1")
    public RetVal welcome1(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("查询成功",null);
    }

    @GetMapping("/welcome2")
    public RetVal welcome2(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("查询成功",null);
    }

    @GetMapping("/welcome3")
    public RetVal welcome3(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("查询成功",null);
    }


    @GetMapping("/welcome4")
    public RetVal welcome4(){

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("查询成功",null);
    }


    @GetMapping("/welcome5")
    public RetVal welcome5(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("查询成功",null);
    }

    @GetMapping("/welcome6")
    public RetVal welcome6(){

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("查询成功",null);
    }

    @GetMapping("/welcome7")
    public RetVal welcome7(){

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("查询成功",null);
    }

    @GetMapping("/welcome8")
    public RetVal welcome8(){

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("查询成功",null);
    }

    @GetMapping("/welcome9")
    public RetVal welcome9(){

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("查询成功",null);
    }


    @GetMapping("/welcome10")
    public RetVal welcome10(){

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("查询成功",null);
    }



}

