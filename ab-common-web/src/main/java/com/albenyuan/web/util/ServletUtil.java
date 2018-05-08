package com.albenyuan.web.util;

import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author Alben Yuan
 * @Date 2018-04-28 08:48
 */
public class ServletUtil {

    public static boolean isAjax(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(header);
    }


    public static ServletContext getContext() {
        return ContextLoader.getCurrentWebApplicationContext().getServletContext();
    }

    public static ServletContext getContext(HttpServletRequest request) {
        return getContext(request.getSession());
    }

    public static ServletContext getContext(HttpSession session) {
        return session.getServletContext();
    }

    public static Object getAttribute(HttpSession session, String name) {
        return session.getAttribute(name);
    }

    /**
     * @param request
     * @param name
     * @return
     */
    public static Object getAttribute(HttpServletRequest request, String name) {
        return request.getAttribute(name);
    }

    /**
     * @param request
     * @return
     */
    public static String getIP(HttpServletRequest request) {
        return request.getRemoteAddr();
    }

}
