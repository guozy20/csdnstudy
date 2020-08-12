package com.guozy.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(20);
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            while(true){
                // localhost 8080

                Socket socket = serverSocket.accept(); // 监听客户端连接（连接阻塞）
                System.out.println(socket.getPort());

                executorService.execute(new SocketThread(socket));
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
