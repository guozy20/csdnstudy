package com.guozy.example.order;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * 处理IO操作，供线程池调用，需要创建线程
 */
public class ProcessHandler implements Runnable{
    private Socket socket;
    private Object service;

    public ProcessHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            // 拿到客户端传递过来的RpcRequest参数
            inputStream = new ObjectInputStream(socket.getInputStream());
            // 反序列化
            RpcRequest rpcRequest = (RpcRequest) inputStream.readObject();
            // 调用反射调用方法
            Object rslt = invoke(rpcRequest);
            System.out.println("服务端的执行结果" + rslt);

            // 在写回到客户端
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rslt);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 通过反射进行服务的调用
     * @param rpcRequest
     * @return
     */
    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName(rpcRequest.getClassName());
        // 根据方法名和参数类型找需要调用的目标方法
        Method method = clazz.getMethod(rpcRequest.getMethodName(), rpcRequest.getTypes());
        // 反射调用我们的服务
        return method.invoke(service, rpcRequest.getArgs());
    }
}
