package com.albenyuan.wx.exception;

/**
 * @Author Alben Yuan
 * @Date 2017-12-06 10:57
 */

public class WxException extends RuntimeException {

    private Integer errorCode;

    public WxException() {
    }

    public WxException(Integer errorCode) {
        super("errcode:" + errorCode);
        this.errorCode = errorCode;
    }

    public WxException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public WxException(Throwable cause) {
        super(cause);
    }

    public WxException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
