package com.guozy.springboot.dubbo.springbootdubboconsumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @DubboReference(interfaceName = "com.guozy.springboot.dubbo.springbootdubboprovider.service.IDemoService",
            generic = true, check = false)
    GenericService genericService;

    @GetMapping("/demo")
    public String demo() {

        return genericService.$invoke("getTest", new String[0], null).toString();
    }
}
