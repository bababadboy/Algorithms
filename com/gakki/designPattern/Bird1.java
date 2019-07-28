package com.gakki.designPattern;

/**
 * @author wangxb (O_o)??)
 * @date 2019-07-17
 */
public class Bird1 implements Fly {
    @Override
    public void fly() {
        System.out.println("Preparing before flying");
        System.out.println("Bird1 is flying...");
        System.out.println("After flying...");
    }
}
