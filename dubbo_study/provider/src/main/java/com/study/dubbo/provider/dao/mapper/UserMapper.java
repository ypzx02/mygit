package com.study.dubbo.provider.dao.mapper;

import com.study.dubbo.model.UserDO;


public interface UserMapper {

    UserDO queryById(Integer id);
}
