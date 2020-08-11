package com.guozy.springboot.dubbo.springbootdubboconsumer;

import com.guozy.springboot.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboConsumerApplication.class, args);
    }

    @DubboReference // 通过dubbo的协议来调用，不能用@Autowired
    ISayHelloService sayHelloService;

    @GetMapping("say")
    public String sayHello(){
        
        return sayHelloService.sayHello("guozy");
    }
}
