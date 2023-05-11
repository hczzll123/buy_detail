package com.hcz.buy_detail.controller;



import com.hcz.buy_detail.config.RetVal;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  压测接口
 * </p>
 *
 * @author hechangzheng
 * @since 2023-05-04
 */
@RestController
@RequestMapping("/t-admin")
public class TAdminController {

    /**
     * httpSimple
     * @return
     */
    @PostMapping("/httpSimple")
    public RetVal httpSimple(@RequestBody String src){
        return RetVal.successWithData("success",null);
    }



    /**
     * 耗时100ms
     * @return
     */
    @PostMapping("/http100")
    public RetVal http100(@RequestBody String src){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("success-100",null);
    }

    /**
     * 耗时1s
     * @return
     */
    @PostMapping("/http1000")
    public RetVal http1000(@RequestBody String src){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("success-1000",null);
    }

    /**
     * 耗时30s
     * @return
     */
    @PostMapping("/http30000")
    public RetVal http30000(@RequestBody String src){

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RetVal.successWithData("success-30000",null);
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
        return RetVal.successWithData("success-BodySize",null);
    }




}

