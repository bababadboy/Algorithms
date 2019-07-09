package com.gakki.basic.exception.checkedAndRuntime;

/**
 * @author wangxiaobin
 * @date 2019/4/27 下午11:29
 */
public class Main {
    static void method1() throws Exception{
        System.out.println("This is method1.");
    }

    static void method2(String s){
        System.out.println("This is method2.");
        if(s == null){
            throw new NullPointerException("String cann't be  null!");
        }
    }

    static void method3() throws Exception{
        method1();
    }

    public static void main(String[] args) {
        try {
            // method1 is a checked Exception.
            method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  method2 is a RuntimeException(unchecked exception)
        method2(null);

        try {
            // method3 is also a checked exception.
            method3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
