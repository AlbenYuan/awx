package com.albenyuan.web.controller;


import com.albenyuan.web.core.BaseResult;
import com.albenyuan.web.core.ErrorCode;
import com.albenyuan.web.core.ResultCode;

/**
 * @Author Alben Yuan
 * @Date 2018-05-04 13:54
 */
public class BaseController {


    protected static BaseResult success() {
        return BaseResult.success();
    }

    protected static BaseResult success(Object data) {
        return BaseResult.success(data);
    }

    protected static BaseResult failure() {
        return failure(ResultCode.ERROR);
    }

    protected static BaseResult failure(ErrorCode code) {
        return BaseResult.failure(code);
    }

}
