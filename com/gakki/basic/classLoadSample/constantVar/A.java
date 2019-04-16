package com.gakki.basic.classLoadSample.constantVar;

/**
 * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 * @author wangxiaobin
 */
public class A {
    public static int a = 233;
    public static final int CONSTANT = 233;
    static {
        System.out.println("Hello I am A.");
    }
}
