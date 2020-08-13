package com.guozy.springboot.dubbo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public interface ISayHelloService {
    @GET
    @Path("/say")
    String sayHello(String msg);
}
