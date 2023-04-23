package com.hcz.buy_detail.config;

import lombok.Data;


@Data
public class RetVal {

    private Boolean success;
    //状态码
    private Integer code;
    //提示信息
    private String message;
    //返回数据
    /**
     * 结果数据
     */
    private Object datas;

    //方法返回统一的格式
    //构造方法私有化
    private RetVal(){ }

    //成功的方法
    public static RetVal successWithData(String message,Object datas) {
        RetVal retVal = new RetVal();
        retVal.setSuccess(true);
        retVal.setCode(RetCode.OK);
        retVal.setDatas(datas);
        retVal.setMessage(message);
        return retVal;
    }
    //失败的方法
    public static RetVal failWithMessage(String message) {
        RetVal retVal = new RetVal();
        retVal.setSuccess(false);
        retVal.setCode(RetCode.ERROR);
        retVal.setMessage(message);
        return retVal;
    }

    //实现链式编程
    public RetVal message(String message){
        this.setMessage(message);
        return this;
    }

    public RetVal code(Integer code){
        this.setCode(code);
        return this;
    }




}
