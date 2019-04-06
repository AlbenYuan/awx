package com.albenyuan.web.interceptor;

import com.albenyuan.common.annotation.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Alben Yuan
 * @Date 2018-05-20 22:40
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (needAuthorization((HandlerMethod) handler)) {

        }
        return super.preHandle(request, response, handler);
    }

    private boolean needAuthorization(HandlerMethod handlerMethod) {
        try {
            Authorization authorization = handlerMethod.getMethodAnnotation(Authorization.class);
            if (null == authorization) {
                authorization = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Authorization.class);
            }
            if (null == authorization) {
                authorization = handlerMethod.getBeanType().getAnnotation(Authorization.class);
            }
            return null != authorization;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;

    }
}
