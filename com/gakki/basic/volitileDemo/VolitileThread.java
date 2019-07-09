package com.gakki.basic.volitileDemo;


/**
 * @author wangxb
 */
public class VolitileThread extends Thread {

    //volatile boolean flag = false;中加的volatile修饰符和没加一样啊
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
