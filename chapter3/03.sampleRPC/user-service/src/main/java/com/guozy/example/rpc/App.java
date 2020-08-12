package com.guozy.example.rpc;

import com.guozy.example.order.IOrderService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // 通过客户端动态代理调用服务端付方法
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IOrderService orderService = rpcProxyClient.clientProxy(IOrderService.class,"localhost",8080);
        System.out.println(orderService.queryOrderList());
        System.out.println(orderService.queryOrderInfoById("1231"));

        System.out.println( "Hello World!" );
    }
}
