package com.hcz.buy_detail.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author Dragon King HCZ
 * @Date 2021/2/5 14:20
 * @Version 1.0
 */
public abstract class BaseController {


    protected HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest().getSession();
    }


    protected HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getResponse();
    }

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
    }


}
