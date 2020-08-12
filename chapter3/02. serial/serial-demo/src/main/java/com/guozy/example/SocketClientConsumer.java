package com.guozy.example;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 序列化，把一个对象转化成特定的形态，然后以数据流的方式传输
 * 序列化是把对象的状态信息转化为可存储或传输的形式过程，也就是把对象转化为字节序列的过程
 */
public class SocketClientConsumer {
    public static void main(String[] args) {
        Socket socket = null;
        ObjectOutputStream out = null;
        try {
            socket = new Socket("localhost",8080);
            User user = new User();
            user.setName("guozy");
            user.setAge(29);
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
