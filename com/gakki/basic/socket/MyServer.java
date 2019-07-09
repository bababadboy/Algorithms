package com.gakki.basic.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangxiaobin
 * @date 2019/4/28 上午12:17
 */
public class MyServer {
    private final static int PORT = 2333;
    private ServerSocket server;

    public MyServer(){
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyServer(int port){
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() throws IOException {
        String data = null;
        Socket client = server.accept();

        // 获取client地址
        String clientAddr = client.getInetAddress().getHostAddress();
        System.out.println("New client from "+ clientAddr);
        // 获取client的数据
        BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));

        while ((data = in.readLine()) != null){
            System.out.println("Message from"+ clientAddr+": " + data);
        }


    }

    public static void main(String[] args) throws Exception{
        MyServer server = new MyServer();
        server.listen();
    }
}
