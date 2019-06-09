package com.study.dubbo.provider.service.stub;

import com.study.dubbo.interfaces.UserService;
import com.study.dubbo.model.UserDO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UserServiceStub implements UserService {

    private UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDO queryById(String id) {
        log.info("provider 调用{}:{}()",getClass(),"queryById");
        return userService.queryById(id);
    }
}
