package com.study.dubbo.consumer.controller;

import com.google.common.base.Stopwatch;
import com.study.dubbo.interfaces.UserService;
import com.study.dubbo.model.UserDO;
import org.apache.dubbo.rpc.service.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserService userService2;

    @GetMapping("/user/{id}")
    public Object queryById(@PathVariable("id") String id){
        Stopwatch started = Stopwatch.createStarted();
        UserDO userDO = userService.queryById(id);
        logger.info("call remote procuder complete {}ms",started.elapsed(TimeUnit.MILLISECONDS));
        return userDO;
    }

    @GetMapping("/user/{id}/2")
    public Object queryById2(@PathVariable("id") String id){
        Stopwatch started = Stopwatch.createStarted();
        UserDO userDO = userService2.queryById(id);
        logger.info("call remote procuder complete {}ms",started.elapsed(TimeUnit.MILLISECONDS));
        return userDO;
    }
}
