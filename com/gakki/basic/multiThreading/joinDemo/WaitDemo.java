package com.gakki.basic.multiThreading.joinDemo;

/**
 * 没有notify，把自己挂起后会无限阻塞等待
 * @author wangxb XD
 * @date 2019-08-04
 */
public class WaitDemo {


    synchronized void join() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After wait()");
    }
    public static void main(String[] args) {
       WaitDemo w = new WaitDemo();
       w.join();
       // 自己不能把自己唤醒
        // main 线程不能 把w对象的所丢了之后，自己主动去拿回来
       w.notify();
    }
}
