package com.gakki.basic.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wangxiaobin
 */
public class NioBufferAndChannel {
    public static void main(String[] args) throws Exception{
        String path = "/Users/wangxiaobin/antigen.zsh";

        RandomAccessFile aFIle = new RandomAccessFile(path,"rw");

        FileChannel channel = aFIle.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1000);
        int byteRead = channel.read(buffer);
        while (byteRead != -1){
            System.out.println("Read "+byteRead);
            // limit置位position,把 position指针归零
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            // 从channel写入buffer
            byteRead = channel.read(buffer);
        }

    }
}
