package com.gakki.basic.futureDemo;

/**
 * @author wangxb (O_o)??)
 * @date 2019-07-18
 */
public class MyRun implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("MyRun is runing...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
