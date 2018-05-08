package com.albenyuan.web.model;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 21:48
 */
public enum ResultCode {
    SUCCESS(0, ""),
    ERROR(-1, "系统异常"),
    REQUEST_PARAM_MISSING(1003, "参数缺失"),
    REQUEST_METHOD_NOT_SUPPORTED(1004, "不支持的请求方式"),
    REQUEST_PARAM_ILLEGAL(1004, "参数不正确"),
    DATA_NOT_FOUND(10002, "数据不可用"),
    DATA_COMMIT_ERROR(1003, "数据提交失败"),
    AUTH_FAILURE(10003, "无权或权限失效"),
    AUTH_CODE_INVALID(10003, "验证码不正确或已失效");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
