package com.study.dubbo.interfaces;

import com.study.dubbo.model.UserDO;

public interface UserService {

    UserDO queryById(String id);
}
