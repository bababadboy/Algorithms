package com.gakki.basic.classLoadSample.constantVar;

/**
 * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 * @author wangxiaobin
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(A.CONSTANT);
    }
}
