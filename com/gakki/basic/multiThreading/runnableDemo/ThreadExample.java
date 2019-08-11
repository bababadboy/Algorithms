package com.gakki.basic.multiThreading.runnableDemo;

/**
 * @author wangxiaobin
 */
public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
            Thread t = new Thread(){
                public void run(){
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Thread: " + getName() + ",count: "+ i);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            //接受到中断信号时，停止运行,不加return,不会停止
                            return;
                        }
                    }
                }
            };

            t.start();

            Thread.sleep(7000);
            // 中断 t 线程
            t.interrupt();
    }
}
