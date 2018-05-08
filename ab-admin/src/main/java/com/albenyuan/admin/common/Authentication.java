package com.albenyuan.admin.common;

import com.albenyuan.admin.form.Login;

import java.util.Random;
import java.util.UUID;

/**
 * @Author Alben Yuan
 * @Date 2018-05-07 15:58
 */
public class Authentication {

    public static AccessToken login(Login login) {
        AccessToken accessToken = new AccessToken();
        accessToken.setToken(UUID.randomUUID().toString());
        return accessToken;
    }

    public static AccessToken validate(String token) {
        AccessToken accessToken = new AccessToken();
        accessToken.setToken(token);
        return accessToken;
    }

}
