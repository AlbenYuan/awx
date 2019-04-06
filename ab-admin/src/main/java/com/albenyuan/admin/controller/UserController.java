package com.albenyuan.admin.controller;

import com.albenyuan.admin.common.AccessToken;
import com.albenyuan.admin.common.Authentication;
import com.albenyuan.admin.form.Login;
import com.albenyuan.admin.service.UserService;
import com.albenyuan.web.core.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 21:45
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public BaseResult login(Login login) {
        Map<String, Object> map = userService.login(login);
        AccessToken accessToken = Authentication.login(login);
        map.put("accessToken", accessToken);
        return BaseResult.success(map);
    }

}
