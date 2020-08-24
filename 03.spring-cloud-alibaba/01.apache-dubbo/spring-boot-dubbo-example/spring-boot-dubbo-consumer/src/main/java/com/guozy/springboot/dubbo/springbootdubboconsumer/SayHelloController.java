package com.guozy.springboot.dubbo.springbootdubboconsumer;

import com.guozy.springboot.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {


    //    @DubboReference(registry = {"shanghai","beijing"},version = "2.0") // 通过dubbo的协议来调用，不能用@Autowired
//   loadbalance 负载均衡算法 consistenthash 一致性hash算法 roundrobin 加权轮询
    @DubboReference(registry = {"beijing","shanghai"},
            protocol = "dubbo",
            loadbalance = "consistenthash",
            mock = "com.guozy.springboot.dubbo.springbootdubboconsumer.MockSayHelloService",
            timeout = 500,
            cluster = "failfast",
            check = false)
    ISayHelloService sayHelloService;

    @GetMapping("say")
    public String sayHello() {
        return sayHelloService.sayHello("guozy");
    }
}
