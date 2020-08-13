package com.guozy.springboot.dubbo.springbootdubboprovider.service;


import com.guozy.springboot.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(registry = {"shanghai", "beijing"},protocol = {"dubbo","rest"})
public class SayHelloServiceImpl implements ISayHelloService {
    @Override
    public String sayHello(String msg) {
        return "hello world！" + msg + "version1.0";
    }
}
