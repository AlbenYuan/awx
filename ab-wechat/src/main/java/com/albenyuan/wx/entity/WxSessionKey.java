package com.albenyuan.wx.entity;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2017-11-14 09:06
 */

public class WxSessionKey implements Serializable {

    private String openId;

    private String sessionKey;

    private String unionId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WxSessionKey{");
        sb.append("openId='").append(openId).append('\'');
        sb.append(", sessionKey='").append(sessionKey).append('\'');
        sb.append(", unionId='").append(unionId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
