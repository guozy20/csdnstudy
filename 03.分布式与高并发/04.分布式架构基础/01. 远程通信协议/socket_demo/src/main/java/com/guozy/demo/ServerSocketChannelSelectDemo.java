package com.guozy.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerSocketChannelSelectDemo {

    static Selector selector;

    public static void main(String[] args) {
        try {
            // selector必须是非阻塞
            selector = Selector.open();

            // [Channel,Buffer,Selector]NIO中重要的三个

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 非阻塞IO默认是阻塞的，需要在此设置为false非阻塞
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//把连接事件注册到多路复用上
            while (true) {
                selector.select(); // 阻塞机制，只有事件到达时才会被唤醒，否则此处是阻塞状态

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterable = selectionKeys.iterator();
                while (iterable.hasNext()) {
                    SelectionKey key = iterable.next();
                    iterable.remove();//用过之后删除
                    if (key.isAcceptable()) { // 连接事件
                        handleAccept(key);
                    } else if(key.isReadable()) { // 读的就绪事件
                        handleRead(key);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleAccept(SelectionKey selectionKey){
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        try {
            SocketChannel socketChannel = serverSocketChannel.accept(); // 这里面一定有一个连接
            socketChannel.configureBlocking(false);
            socketChannel.write(ByteBuffer.wrap("Hello,I'm NIO server".getBytes()));
            socketChannel.register(selector,SelectionKey.OP_READ); //注册一个读的事件(SocketChannel)

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRead(SelectionKey selectionKey){
        // 取得连接事件处理后注册的读事件
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            socketChannel.read(byteBuffer);
            System.out.println("server receive msg " + new String(byteBuffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
