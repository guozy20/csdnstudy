package com.guozy.springboot.dubbo.springbootdubboprovider.service.impl;


import com.guozy.springboot.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

@DubboService(registry = {"shanghai", "beijing"},protocol = {"dubbo","rest"})
public class SayHelloServiceImpl implements ISayHelloService {
    @Value("${dubbo.protocols.dubbo.port}")
    private Integer port;

    @Override
    public String sayHello(String msg) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("msg:" + System.currentTimeMillis());
        return "hello world！" + msg + "version1.0"+",port:"+port;
    }
}
