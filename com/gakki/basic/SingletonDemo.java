package com.gakki.basic;

import java.util.HashMap;
import java.util.Map;

public class SingletonDemo {
    private static SingletonDemo ourInstance = new SingletonDemo();

    public static SingletonDemo getInstance() {
        return ourInstance;
    }

    private SingletonDemo() {
    }
    public static void main(String[] args){
        SingletonDemo singletonDemo = SingletonDemo.getInstance();
        Map map = new HashMap();
        map.keySet();
        String s = "ddd";
        char[] chars = {'a','d'};
        System.out.println(chars.toString().replaceAll("a", ""));

    }
}
