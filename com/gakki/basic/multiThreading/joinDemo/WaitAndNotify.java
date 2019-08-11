package com.gakki.basic.multiThreading.joinDemo;

/**
 * @author wangxb XD
 * @date 2019-08-04
 */
public class WaitAndNotify {

    public static void main(String[] args) {

        final Object o = new Object();

        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                synchronized (o){   // 获取o对象的内置锁
                    System.out.println("Thread "+ Thread.currentThread().getName()+ " start running...");

                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Thread "+ Thread.currentThread().getName()+ " stopped");
                }
            }
        };


        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                synchronized (o){
                    try {   // 先让t2睡眠一会
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread "+ Thread.currentThread().getName()+ " start running...");

                    o.notify();

                    System.out.println("Thread "+ Thread.currentThread().getName()+ " stopped");
                }

            }
        };

        t1.start();
        t2.start();

    }
}
