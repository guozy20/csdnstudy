package com.guozy.springboot.dubbo.springbootdubboprovider.service;


import com.guozy.springboot.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class SayHelloServiceImpl implements ISayHelloService {
    @Override
    public String sayHello(String msg) {
        return "hello world！" + msg;
    }
}
