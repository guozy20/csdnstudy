package com.guozy.springboot.dubbo.springbootdubboprovider.service.impl;

import com.guozy.springboot.dubbo.springbootdubboprovider.service.IDemoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(protocol = {"dubbo"})
public class DemoServiceImpl implements IDemoService {
    @Override
    public String getTest() {
        return "hello dubbo,泛化";
    }
}
