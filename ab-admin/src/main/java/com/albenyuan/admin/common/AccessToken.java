package com.albenyuan.admin.common;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2018-05-07 15:59
 */
public class AccessToken implements Serializable {

    private static final long serialVersionUID = 9140239080574688364L;

    private String token;
    private long expire;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }
}
