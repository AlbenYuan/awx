package com.albenyuan.admin.dao;

import com.albenyuan.admin.entity.User;
import com.albenyuan.repository.StateRepository;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends StateRepository<User, String> {


    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}