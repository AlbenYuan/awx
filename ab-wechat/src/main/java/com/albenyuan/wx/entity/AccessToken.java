package com.albenyuan.wx.entity;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2017-12-06 10:51
 */

public class AccessToken implements Serializable {

    private String accessToken;     // 调用接口凭证

    private Integer expiresIn;      // 实效

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AccessToken{");
        sb.append("accessToken='").append(accessToken).append('\'');
        sb.append(", expiresIn=").append(expiresIn);
        sb.append('}');
        return sb.toString();
    }
}
