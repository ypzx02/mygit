package com.study.dubbo.consumer.stub;

import com.study.dubbo.interfaces.UserService;
import com.study.dubbo.model.UserDO;
import lombok.extern.log4j.Log4j2;
import org.apache.dubbo.rpc.service.EchoService;

@Log4j2
public class UserServiceStub implements UserService, EchoService {

    private UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDO queryById(String id) {
        UserDO userDO = userService.queryById(id);
        log.info("使用了本地存根");
        return userDO;
    }

    @Override
    public Object $echo(Object message) {
        return ((EchoService) userService).$echo(message);
    }
}
