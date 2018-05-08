package com.albenyuan.admin.service.impl;

import com.albenyuan.admin.dao.UserMapper;
import com.albenyuan.admin.entity.User;
import com.albenyuan.admin.form.Login;
import com.albenyuan.admin.service.UserService;
import com.albenyuan.repository.StateRepository;
import com.albenyuan.web.service.impl.StateServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Alben Yuan
 * @Date 2018-05-05 22:20
 */
@Service
public class UserServiceImpl extends StateServiceImpl<User, String> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    protected StateRepository<User, String> getDao() {
        return userMapper;
    }

    @Override
    public Map<String, Object> login(Login login) {
        Map<String, Object> map = new HashMap<>();
        Page<User> page = PageHelper.startPage(1, 10, true);
        List<User> list = userMapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        map.put("login", login);
        map.put("page", pageInfo);
        return map;
    }
}
