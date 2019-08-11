package com.gakki.basic.multiThreading.threadDemo;

/**
 * @author wangxiaobin
 */
public class MutiPrint2 extends Thread {
    @Override
    public void run() {
        for (int i = 0 ; i < 10; i ++) {
            System.out.println("This is the number: "+i + " from mutiPrint2");
            try{
                sleep(10);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
