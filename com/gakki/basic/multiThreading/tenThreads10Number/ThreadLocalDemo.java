package com.gakki.basic.multiThreading.tenThreads10Number;

/**
 * 把ThreadLocal当做工具函数
 * 十个线程，打印1-10，利用ThreadLocal避免同步问题
 * @author wangxb (O_o)??)
 * @date 2019-09-07
 */
public class ThreadLocalDemo implements Runnable{

    private static ThreadLocal<Integer> threadLocalVal = new ThreadLocal<>();
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public ThreadLocalDemo(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        threadLocalVal.set(id);
        System.out.println(threadLocalVal.get());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new ThreadLocalDemo(i+1));
            t.start();
        }
    }
}
