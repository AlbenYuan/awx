package com.albenyuan.web.core;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 21:46
 */

public class BaseResult<T> implements Serializable {

    private boolean success = true;

    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer code;

    public static BaseResult success(Object data) {
        return new BaseResult<>(data);
    }

    public static BaseResult success() {
        return success(null);
    }

    public static BaseResult failure(ErrorCode resultCode) {
        return new BaseResult(resultCode);
    }

    private BaseResult(T data) {
        this.data = data;
    }

    private BaseResult(ErrorCode errorCode) {
        if (null == errorCode) {
            errorCode = ResultCode.ERROR;
        }
        this.success = false;
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
