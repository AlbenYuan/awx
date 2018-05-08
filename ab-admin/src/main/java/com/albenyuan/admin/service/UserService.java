package com.albenyuan.admin.service;

import com.albenyuan.admin.entity.User;
import com.albenyuan.admin.form.Login;
import com.albenyuan.web.service.StateService;

import java.util.Map;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 22:19
 */
public interface UserService extends StateService<User, String> {

    Map<String, Object> login(Login login);

}
