package com.gakki.basic.multiThreading.threadDemo;

import static java.lang.Thread.sleep;

/**
 * 多线程基础
 * @author wangxiaobin
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MutiPrint1 mutiPrint = new MutiPrint1();
        MutiPrint2 mutiPrint2 = new MutiPrint2();
        mutiPrint2.run();
        mutiPrint.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("This is the number from main: "+i);
            try{
                sleep(10);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
