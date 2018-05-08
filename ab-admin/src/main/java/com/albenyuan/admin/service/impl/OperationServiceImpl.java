package com.albenyuan.admin.service.impl;

import com.albenyuan.admin.dao.OperationMapper;
import com.albenyuan.admin.entity.Operation;
import com.albenyuan.admin.service.OperationService;
import com.albenyuan.repository.TreeRepository;
import com.albenyuan.web.service.impl.TreeServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Alben Yuan
 * @Date 2018-05-06 12:09
 */
@Service
public class OperationServiceImpl
        extends TreeServiceImpl<Operation, String>
        implements OperationService {

    @Resource
    private OperationMapper operationMapper;


    @Override
    protected TreeRepository getDao() {
        return operationMapper;
    }
}
