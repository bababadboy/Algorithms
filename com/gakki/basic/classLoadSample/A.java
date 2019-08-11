package com.gakki.basic.classLoadSample;

/**
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * @author wangxiaobin
 */
public class A {
    static {
        System.out.println("Hello I am BaseA.");
    }
}
