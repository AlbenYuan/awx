package com.albenyuan.wx.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author Alben Yuan
 * @Date 2018-04-27 22:18
 */
public enum Scope {
    BASE("snsapi_base"), USERINFO("snsapi_userinfo");
    private String code;

    Scope(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public Scope getByCode(String code) {
        if (StringUtils.isNotEmpty(code)) {
            for (Scope scope : Scope.values()) {
                if (code.equals(scope.getCode())) {
                    return scope;
                }
            }
        }
        return null;
    }
}
