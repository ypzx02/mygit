package com.study.dubbo.provider.service.impl;

import com.study.dubbo.interfaces.UserService;
import com.study.dubbo.model.UserDO;
import com.study.dubbo.provider.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO queryById(String id) {
        UserDO userDO = new UserDO();
            userDO = userMapper.queryById(Integer.valueOf(id));
        return userDO;

    }
}
