package com.gakki.basic.multiThreading;

/**
 * @author wangxiaobin
 */
public class MutiPrint1 extends Thread {
    @Override
    public void run() {
        for (int i = 0 ; i < 10; i ++) {
            System.out.println("This is the number: "+i + " from mutiPrint1");
            try{
                sleep(10);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
