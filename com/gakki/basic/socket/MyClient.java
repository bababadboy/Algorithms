package com.gakki.basic.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wangxiaobin
 * @date 2019/4/28 上午12:11
 */
public class MyClient {
    private final static int PORT = 2333;
    private final static String IP_ADDRESS = "106.14.191.82";
    private Socket socket;
    private Scanner scanner;

    public MyClient() throws IOException {
        socket = new Socket(IP_ADDRESS,PORT);
        scanner = new Scanner(System.in);
    }

    public MyClient(String ip, int port) throws IOException {
        socket = new Socket(ip,port);
        scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        String input;

        while (true){
            input = scanner.next();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(input);
            out.flush();
        }
    }

    public static void main(String[] args) throws Exception{

        MyClient client = new MyClient();
        System.out.println("\r\nConnected to Server: " + client.socket.getInetAddress());
        client.start();
    }
}
