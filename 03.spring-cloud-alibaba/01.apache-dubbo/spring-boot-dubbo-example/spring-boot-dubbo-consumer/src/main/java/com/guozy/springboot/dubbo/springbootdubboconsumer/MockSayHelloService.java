package com.guozy.springboot.dubbo.springbootdubboconsumer;

import com.guozy.springboot.dubbo.ISayHelloService;

public class MockSayHelloService implements ISayHelloService {
    @Override
    public String sayHello(String msg) {
        return "触发服务降级";
    }
}
