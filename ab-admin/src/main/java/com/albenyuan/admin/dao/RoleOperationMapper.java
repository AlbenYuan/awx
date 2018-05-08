package com.albenyuan.admin.dao;

import com.albenyuan.admin.entity.RoleOperation;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleOperationMapper {
    
    int deleteByPrimaryKey(String id);

    int insert(RoleOperation record);

    int insertSelective(RoleOperation record);

    RoleOperation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleOperation record);

    int updateByPrimaryKey(RoleOperation record);
}