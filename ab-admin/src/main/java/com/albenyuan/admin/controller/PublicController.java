package com.albenyuan.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author Alben Yuan
 * @Date 2018-05-07 11:48
 */
@Controller
public class PublicController {

    private int start = 0;

    private ServletContext servletContext;

    @Resource
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
        this.start = this.servletContext.getContextPath().length();
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/**/*.htm"})
    public String htm(HttpServletRequest request) {
        String uri = request.getRequestURI();
        int end = uri.length() - 4;
        logger.info("path:{}", uri.substring(start, end));
        return "/public" + uri.substring(start, end);
    }

}
