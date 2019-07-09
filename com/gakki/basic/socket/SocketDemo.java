package com.gakki.basic.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wangxiaobin
 */
public class SocketDemo {
    public static void main(String[] args) throws Exception{

        Socket socket  = new Socket("http://jenkov.com/",80);

//        OutputStream out= socket.getOutputStream();
//        out.write("Socket data".getBytes());
//        out.flush();
//        out.close();


        InputStream in= socket.getInputStream();
        int data = in.read();
        System.out.println(data);
        in.close();

        socket.close();
    }
}
