package com.gakki.basic.volitileDemo;

import java.util.concurrent.*;

/**
 * @author wangxb
 */
public class RunnableMain {
    public static void main(String[] args) throws Exception{
        VolatileRunnable test = new VolatileRunnable();


        System.out.println("test中的i="+test.i);
    }
}
