package com.gakki.basic.classLoadSample;

/**
 * @author wangxiaobin
 */
public class C extends B {
    static {
        System.out.println("Hello, I am C.");
    }

    static int c;
    public C(){
        System.out.println("This is C, over.");
    }

}
