package com.gakki.basic.io;


import java.io.*;

/**
 * @author wangxb XD
 * @date 2019-09-21
 */
public class Main {
    public static void main(String[] args) throws IOException {

        FileUtils fileUtils = FileUtils.getInstance();
        long start = System.currentTimeMillis();
        fileUtils.memeoryCopy("/Users/not-bad/Movies/yourturn/01.mp4",
                "/Users/not-bad/Movies/yourturn/01-copy.mp4");

        long end = System.currentTimeMillis();
        System.out.println("时间耗费:"+ (end-start));

    }
}
