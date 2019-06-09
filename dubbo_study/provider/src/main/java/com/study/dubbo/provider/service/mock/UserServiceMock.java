package com.study.dubbo.provider.service.mock;

import com.study.dubbo.interfaces.UserService;
import com.study.dubbo.model.UserDO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UserServiceMock implements UserService {
    @Override
    public UserDO queryById(String id) {
        log.error("provider 服务处理异常 Mock {}:{}()",getClass(),"queryById");
        return null;
    }
}
