package com.gakki.basic.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * @author wangxiaobin
 */
public class NioSelector {
    public static void main(String[] args) throws Exception{
        // 创建一个Selector
        Selector selector = Selector.open();
        // selector与channel管理
        String path = "/Users/wangxiaobin/antigen.zsh";
        RandomAccessFile file = new RandomAccessFile(path,"rw");

        FileChannel channel = file.getChannel();
//        channel.configureBlocking

    }
}
