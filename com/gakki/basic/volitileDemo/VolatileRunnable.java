package com.gakki.basic.volitileDemo;

/**
 * @author wangxb
 */
public class VolatileRunnable implements Runnable{

    boolean flag = false;
    int i = 0;

    @Override
    public void run() {
        while (!flag){
            i ++;
            System.out.println("i="+i);
        }
    }

}
