package com.albenyuan.admin.controller;

import com.albenyuan.web.controller.BaseController;
import com.albenyuan.web.core.BaseResult;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Properties;

/**
 * @Author Alben Yuan
 * @Date 2018-05-19 19:59
 */
@RestController
@RequestMapping("/system")
public class SystemController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/message")
    public BaseResult message(HttpServletRequest request) {
        Properties props = System.getProperties();
        Runtime runtime = Runtime.getRuntime();
        ServletContext servletContext = request.getServletContext();
//        String mysqlVersion = sysConfigService.getMysqlVsesion();
        logger.info("props:{}", props);

        Map<String, Object> result = ImmutableMap.<String, Object>builder()
                .put("javaVersion", props.getProperty("java.version"))
                .put("osName", props.getProperty("os.name"))
                .put("osVersion", props.getProperty("os.version"))
                .put("userHome", props.getProperty("user.home"))
                .put("userDir", props.getProperty("user.dir"))
                .put("clientIP", request.getLocalAddr())
                .put("serverIP", request.getRemoteAddr())
                .put("cpu", runtime.availableProcessors())
                .put("totalMemory", runtime.totalMemory() / 1024 / 1024 + "M")
                .put("freeMemory", runtime.freeMemory() / 1024 / 1024 + "M")
                .put("maxMemory", runtime.maxMemory() / 1024 / 1024 + "M")
                .put("webVersion", servletContext.getServerInfo())
//                .put("mysqlVersion", mysqlVersion)
                .put("webRootPath", servletContext.getRealPath(""))
//                .put("systemVersion", Constants.SYSTEM_VERSION)
//                .put("systemName", Constants.SYSTEM_NAME)
//                .put("systemUpdateTime", Constants.SYSTEM_UPDATE_TIME)
                .build();
        return BaseResult.success(result);
    }
}
