package com.gakki.basic.lambda;

import java.util.Arrays;

/**
 * lambda表达式初探
 * @author wangxiaobin
 */
public class Main {
    public static void main(String[] args) {

//        MathOperation mathOperation = (a,b) -> a+b;
        Main m = new Main();
        System.out.println(m.operate(3,4,(a,b) -> a+b));
        System.out.println(m.operate(3,4,(a,b) -> a-b));
        System.out.println(m.operate(3,4,(a,b) -> a*b));

    }
    interface MathOperation{
        int operation(int a, int b);

    }
    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }

}
