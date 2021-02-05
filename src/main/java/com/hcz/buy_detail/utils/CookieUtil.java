package com.hcz.buy_detail.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Dragon King HCZ
 * @Date 2021/2/5 14:23
 * @Version 1.0
 */
public class CookieUtil {

    public static Cookie getCookie(HttpServletRequest request, String key) {
        if(request == null || key == null) {
            return null;
        }
        Cookie[] cookies = request.getCookies();

        if(StringUtils.checkValNotNull(cookies)){
            for (Cookie cookie : cookies) {
                if (key.equals(cookie.getName())) {
                    return cookie;
                }
            }

        }
        return null;
    }

    public static String getCookieValue(HttpServletRequest request, String key) {
        Cookie cookie = getCookie(request, key);
        if(cookie != null) {
            return cookie.getValue();
        }
        return null;
    }


    public static boolean setCookie(HttpServletRequest request, HttpServletResponse response,
                                    String key, String value) {
        return setCookie(request, response, key, value, null);
    }

    private static boolean setCookie(HttpServletRequest request, HttpServletResponse response,
                                     String key, String value, Integer maxAge) {
        if(request == null || response == null || key == null) {
            return false;
        }
        Cookie[] cookies = request.getCookies();
        Cookie tempCookie = null;
        if(StringUtils.checkValNull(cookies)) {
            for (Cookie cookie : cookies) {
                if (key.equals(cookie.getName())) {
                    tempCookie = cookie;
                }
            }
        }
        if (tempCookie != null) {
            org.apache.commons.lang.ArrayUtils.removeElement(cookies, tempCookie);
        }
        Cookie cookie = new Cookie(key, value);
        if(maxAge != null) {
            cookie.setMaxAge(maxAge);
        }

        // 防止被JS修改
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
        return true;
    }


}
