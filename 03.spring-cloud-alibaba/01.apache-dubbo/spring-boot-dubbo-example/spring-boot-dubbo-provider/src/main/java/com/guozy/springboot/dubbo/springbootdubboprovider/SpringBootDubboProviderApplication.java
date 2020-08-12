package com.guozy.springboot.dubbo.springbootdubboprovider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan(basePackages = "com.guozy.springboot.dubbo.springbootdubboprovider.service")
@SpringBootApplication
public class SpringBootDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboProviderApplication.class, args);
    }

}
