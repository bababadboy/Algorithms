package com.gakki.basic.multiThreading.runnableDemo;

/**
 * @author wangxiaobin
 */
public class runnableDemo {
    public static void main(String[] args) {
        Cake cake = new Cake(100);
        Thread t1 = new Thread(cake);
        Thread t2 = new Thread(cake);
        t1.start();
        t2.start();
    }
}
