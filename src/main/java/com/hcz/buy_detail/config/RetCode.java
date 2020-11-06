package com.hcz.buy_detail.config;

/**
 * @author Dragon-king
 * @createdate 2020/3/12 - 18:38
 */
//定义操作状态码
public interface RetCode {

    int OK = 20000;//成功
    int ERROR = 20001;//失败
    int LOGIN_ERROR = 20002;//用户名或密码错误
    int ACCESS_ERROR = 20003;//权限不足
    int REMOTE_ERROR = 20004;//远程调用失败
    int REPEAT_ERROR = 20005;//重复操作
}
