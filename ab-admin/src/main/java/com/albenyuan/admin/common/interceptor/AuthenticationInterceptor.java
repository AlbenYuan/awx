package com.albenyuan.admin.common.interceptor;

import com.albenyuan.admin.common.AccessToken;
import com.albenyuan.admin.common.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Alben Yuan
 * @Date 2018-05-07 16:03
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authentication");
        AccessToken accessToken = Authentication.validate(token);
        if (accessToken == null) {
            StringBuffer url = request.getRequestURL();
            String redirectUrl = "/login.htm?redirectUrl=" + response.encodeRedirectURL(url.toString());
            logger.info("url:{}", url);
            logger.info("redirectUrl:{}", redirectUrl);
            response.sendRedirect(redirectUrl);
        }
        return super.preHandle(request, response, handler);
    }
}
