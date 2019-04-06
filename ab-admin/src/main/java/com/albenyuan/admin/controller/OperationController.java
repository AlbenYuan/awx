package com.albenyuan.admin.controller;

import com.albenyuan.admin.service.OperationService;
import com.albenyuan.web.core.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Alben Yuan
 * @Date 2018-05-06 12:15
 */
@RestController
@RequestMapping("/operation")
public class OperationController {


    @Resource
    private OperationService operationService;

    @RequestMapping("/tree")
    public BaseResult tree() {
        return BaseResult.success();
    }

}
