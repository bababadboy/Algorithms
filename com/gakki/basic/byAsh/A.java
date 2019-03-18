package com.gakki.basic.byAsh;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangxiaobin
 */
class C extends A{
    static {
        System.out.println("Hello I am is C.");
    }
    C(){
        System.out.println("This is C, over.");
    }
}
public class A extends B {
    {
        int a = 233;
    }
    private static final int a = 233;
    static {
        System.out.println("The initial value of a is " + a);
    }
    public static void fun(){
        System.out.println("The is a function from A.");
    }
    public A() {
        System.out.println("This is A, over.");
    }

    public static void main(String[] args) {
        A a1 = new A();
        B b1 = new A();
    }
}


