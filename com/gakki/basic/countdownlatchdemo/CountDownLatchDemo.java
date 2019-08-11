package com.gakki.basic.countdownlatchdemo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 使用CountDownLatch倒数,盲猜list没有实现同步，导致list最终大小小于NUM
 * @author wangxb (O_o)??)
 * @date 2019-08-08
 */
public class CountDownLatchDemo implements Runnable{

    private static List<String> list = new LinkedList<>();
    private static final int NUM = 10;
    private static CountDownLatch start = new CountDownLatch(NUM);
    private static CountDownLatch end = new CountDownLatch(NUM);

    @Override
    public void run() {
        // 让所有的线程都准本就绪
        start.countDown();
        try {
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 不加synchronized会list不同步
        synchronized (this){
            list.add(String.valueOf(System.currentTimeMillis()));
        }
        end.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo run = new CountDownLatchDemo();
        for (int i = 0; i < NUM; i++) {
            new Thread(run).start();
        }
        // 等待三个线程都结束
        end.await();

        for (String item : list) {
            System.out.println(item);
        }
    }
}
