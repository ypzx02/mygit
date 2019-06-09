package com.study.dubbo.provider.service.impl;

import com.study.dubbo.interfaces.UserService;
import com.study.dubbo.model.UserDO;
import com.study.dubbo.provider.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class UserServiceImpl2 implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO queryById(String id) {
        UserDO userDO = userMapper.queryById(Integer.valueOf(id) + 1);
        return userDO;
    }
}
