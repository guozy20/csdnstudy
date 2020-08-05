package com.guozy.socket;

import com.sun.org.apache.bcel.internal.generic.IFNONNULL;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIONewClientDemo {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
//            socketChannel.configureBlocking(false); //false 设置为非阻塞
            socketChannel.connect(new InetSocketAddress("localhost",8080));
            // 在这段代码中，并不意味着连接已经建立好了
            // 需要判断
            if (socketChannel.isConnectionPending()) {
                socketChannel.finishConnect();// 完成连接
            }

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("Hello,I'm socketChnanel clinet".getBytes());

            byteBuffer.flip(); // 也需要反转
            socketChannel.write(byteBuffer);

            // 读取数据
            byteBuffer.clear();
            int i = socketChannel.read(byteBuffer); // 上面不设为非阻塞，则此处会阻塞
            if (i > 0) {
                System.out.println("收到了服务端的数据" + new String(byteBuffer.array()));
            } else {
                System.out.println("没有收到数据");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
