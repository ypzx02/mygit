package com.study.dubbo.consumer.mock;

import com.study.dubbo.interfaces.UserService;
import com.study.dubbo.model.UserDO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UserServiceMock implements UserService {

    @Override
    public UserDO queryById(String id) {
        //log.error("{}:{}()服务调用出现异常",getClass(),"queryById");
        return null;
    }
}
