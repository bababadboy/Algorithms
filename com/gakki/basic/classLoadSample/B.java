package com.gakki.basic.classLoadSample;

/**
 * @author wangxiaobin
 */
public class B extends A {
    static {
        System.out.println("Hello I am B.");
    }

    public static int value = 233;

    public B(){
        System.out.println("This is B, over.");
    }
}
