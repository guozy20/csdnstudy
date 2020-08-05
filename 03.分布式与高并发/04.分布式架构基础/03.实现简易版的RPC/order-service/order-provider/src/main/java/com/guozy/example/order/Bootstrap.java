package com.guozy.example.order;

public class Bootstrap {
    public static void main(String[] args) {
        // SpringBootApplication
        IOrderService orderService = new OrderServiceImpl();
        RpcProxyService rpcProxyService = new RpcProxyService();
        rpcProxyService.publisher(orderService, 8080);
    }
}
