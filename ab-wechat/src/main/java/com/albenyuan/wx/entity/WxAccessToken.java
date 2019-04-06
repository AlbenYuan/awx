package com.albenyuan.wx.entity;

import java.io.Serializable;

public class WxAccessToken implements Serializable {
    private String accessToken;     //接口调用凭证
    private String refreshToken;    //户刷新access_token
    private Integer expiresIn;      // access_token接口调用凭证超时时间，单位（秒）
    private String openId;          // 授权用户唯一标识
    private String scope;           //用户授权的作用域，使用逗号（,）分隔

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WxAccessToken{");
        sb.append("accessToken='").append(accessToken).append('\'');
        sb.append(", refreshToken='").append(refreshToken).append('\'');
        sb.append(", expiresIn=").append(expiresIn);
        sb.append(", openId='").append(openId).append('\'');
        sb.append(", scope='").append(scope).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
