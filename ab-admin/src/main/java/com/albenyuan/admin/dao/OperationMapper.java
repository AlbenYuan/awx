package com.albenyuan.admin.dao;

import com.albenyuan.admin.entity.Operation;
import com.albenyuan.repository.TreeRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationMapper
        extends TreeRepository<Operation, String> {

    int deleteByPrimaryKey(String id);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);
}