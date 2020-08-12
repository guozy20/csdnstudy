package com.guozy.springcloud.dubbo.springclouddubboprovider.service;

import com.guozy.springcloud.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.Service;


public class SayHelloServiceImpl implements ISayHelloService {
    @Override
    public String sayHello(String msg) {
        return "hello world！" + msg;
    }
}
