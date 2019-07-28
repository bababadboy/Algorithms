package com.gakki.basic.futureDemo;

/**
 * @author wangxb (O_o)??)
 * @date 2019-07-18
 */
public class Run2 implements  Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("Run2 is runing... ");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
