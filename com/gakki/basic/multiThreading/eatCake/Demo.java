package com.gakki.basic.multiThreading.eatCake;

/**
 * @author wangxiaobin
 */
public class Demo {
    public static void main(String[] args){
        Cake cake = new Cake(100);

        EatCake e1 = new EatCake(cake,"wxb");
        EatCake e2 = new EatCake(cake,"ggg");
        EatCake e3 = new EatCake(cake,"ant");

        e1.run();
        e2.run();
        e3.run();
    }
}
