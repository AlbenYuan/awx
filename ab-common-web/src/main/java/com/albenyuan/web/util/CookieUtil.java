package com.albenyuan.web.util;

import com.albenyuan.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Alben Yuan
 * @Date 2018-07-13 14:22
 */
public class CookieUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(CookieUtil.class);

    public static void add(HttpServletResponse response, String name, Object value, int age) {
        try {
            Cookie cookie = new Cookie(name, null == value ? null : value.toString());
            if (age > 0)
                cookie.setMaxAge(age);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            LOGGER.warn("add cookie '{}={}' error.", name, value, e);
        }
    }

    public static boolean clear(HttpServletRequest request, HttpServletResponse response, String name) {
        boolean bool = false;
        Cookie[] cookies = request.getCookies();
        if (null == cookies || cookies.length == 0) return bool;
        try {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = new Cookie(name, null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                bool = true;
            }
        } catch (Exception e) {
            LOGGER.warn("clear cookie '{}' error！", name, e);
        }
        return bool;
    }

    public static String get(HttpServletRequest request, String name) {
        if (StringUtils.isNotEmpty(name)) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;

    }
}
