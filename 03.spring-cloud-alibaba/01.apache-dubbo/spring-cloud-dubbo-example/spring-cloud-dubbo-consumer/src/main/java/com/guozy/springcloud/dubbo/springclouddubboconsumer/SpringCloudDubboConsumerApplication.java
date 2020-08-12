package com.guozy.springcloud.dubbo.springclouddubboconsumer;

import com.guozy.springcloud.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringCloudDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboConsumerApplication.class, args);
    }

    @Reference // 通过dubbo的协议来调用，不能用@Autowired
    ISayHelloService sayHelloService;

    @GetMapping("say")
    public String sayHello(){
        return sayHelloService.sayHello("guozy");
    }
}
