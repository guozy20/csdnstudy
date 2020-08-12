package com.guozy.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {
    public static void main(String[] args) {
        try {
            // [Channel,Buffer,Selector]NIO中重要的三个

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 非阻塞IO默认是阻塞的，需要在此设置为false非阻塞
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(8080));
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept(); //监听一个客户端的请求
                if (socketChannel != null) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    socketChannel.read(byteBuffer); // 把数据读取到缓冲区
                    System.out.println(new String(byteBuffer.array()));

                    //写出数据
                    byteBuffer.flip(); //需要 反转
                    socketChannel.write(byteBuffer);  // 写出去
                }else{
                    Thread.sleep(1000);
                    System.out.println("连接未就绪");
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
