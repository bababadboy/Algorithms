package com.gakki;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("aaa");
        String s = null;
        sb.append(s);


        List<String> l1 = new ArrayList<>(10);
        l1.add("sss");

        ArrayList<String> l3 = new ArrayList<>(10);
        l3.add("gg");
        l3.add("kk");
        l3.trimToSize();  // 缓解内存
        l3.get(0);
        l3.add(1,"dd");
        l3.forEach(a-> System.out.println(a));
        System.out.println("l3===>"+l3);

        LinkedList<String> l2 = new LinkedList<>();
        l2.add("dd");

        System.out.println(4>>1);

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }

}
