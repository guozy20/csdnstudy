package com.guozy.example.rpc;

import java.lang.reflect.Proxy;

public class RpcProxyClient {

    // 版本1
    /*public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // TODO 可以在此做很多实现
                return "hello guozy";
            }
        });
    }*/

    /**
     * 版本2，把InvocationHandler里的实现单独提出来
     * @param interfaceCls 动态代理接口的class类
     * @param host 远程服务地址
     * @param port 远程服务地址端口
     * @param <T>
     * @return
     */
    public <T> T clientProxy(final Class<T> interfaceCls, final String host, final int port) {
        // 动态代理，减少类的创建
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls},
                new RemoteInvocationHandler(host, port));
    }
}
