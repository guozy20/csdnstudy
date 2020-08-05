package com.guozy.socket;

import java.io.*;
import java.net.Socket;

public class SocketClientDemo {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost",8080);
            Thread.sleep(100000);

            // 给客户端写入信息
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我是客户端，发送了一条信息\n");
            bufferedWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverStr = bufferedReader.readLine(); // 读取服务端返回得信息
            System.out.println("我收到了客户端的信息：" + serverStr);

        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
