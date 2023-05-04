package com.hcz.buy_detail.controller;



import com.hcz.buy_detail.config.RetVal;
import org.springframework.web.bind.annotation.*;


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

    /**
     * httpSimple
     * @return
     */
    @GetMapping("/httpSimple")
    public RetVal httpSimple(){
        return RetVal.successWithData("响应成功",null);
    }



    /**
     * 耗时100ms
     * @return
     */
    @GetMapping("/http100")
    public RetVal http100(){

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("响应成功",null);
    }

    /**
     * 耗时1s
     * @return
     */
    @GetMapping("/http1000")
    public RetVal http1000(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("响应成功",null);
    }

    /**
     * 耗时30s
     * @return
     */
    @GetMapping("/http30000")
    public RetVal http30000(){

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("响应成功",null);
    }


    /**
     * 报文大小http接口
     * @return
     */
    @PostMapping("/httpBodySize")
    public RetVal httpBodySize(@RequestBody String src){

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("响应成功",null);
    }




}

