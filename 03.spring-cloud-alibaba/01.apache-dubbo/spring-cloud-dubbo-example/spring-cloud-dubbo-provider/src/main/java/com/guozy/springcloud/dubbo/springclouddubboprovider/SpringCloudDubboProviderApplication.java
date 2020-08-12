package com.guozy.springcloud.dubbo.springclouddubboprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboProviderApplication.class, args);
    }

}
