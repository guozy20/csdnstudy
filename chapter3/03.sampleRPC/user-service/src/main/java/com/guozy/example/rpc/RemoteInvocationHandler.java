package com.guozy.example.rpc;

import com.guozy.example.order.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 可以在此处 先建立远程连接
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host, port);
        // 建立socket连接
//        rpcNetTransport.newSocket();//此处建立的连接放到send方法里了，这里不需要建立连接了
        // 建立好连接就可以传递数据了， 调用哪个接口、哪个方法、方法的参数，那就在此处定义一个契约
        RpcRequest request = new RpcRequest();
        request.setArgs(args); // 参数
        request.setClassName(method.getDeclaringClass().getName()); // class类名称
        request.setTypes(method.getParameterTypes()); // 参数类型
        request.setMethodName(method.getName()); // 方法名

        // 建立连接，并向服务端发送、接收数据
        return rpcNetTransport.send(request);
    }
}
