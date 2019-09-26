package com.gakki;

import edu.princeton.cs.algs4.In;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        StringBuilder sb = new StringBuilder("abc");
//        String s = null;
//        sb.append(s);
//
//
//        List<String> l1 = new ArrayList<>(10);
//        l1.add("sss");
//
//        ArrayList<String> l3 = new ArrayList<>(10);
//        l3.add("gg");
//        l3.add("kk");
//        l3.trimToSize();  // 缓解内存
//        l3.get(0);
//        l3.add(1,"dd");
//        l3.forEach(a-> System.out.println(a));
//        System.out.println("l3===>"+l3);
//
//        LinkedList<String> l2 = new LinkedList<>();
//        l2.add("dd");
//
//        System.out.println(4>>1);
//
//        byte[] bytes = sb.toString().getBytes(StandardCharsets.UTF_8);
//        for (byte b :
//                bytes) {
//            System.out.print(b+" ");
//        }
//
//        int c_code = 'a';
//        System.out.println(c_code);
//
//        char cc= '中';
//
//        System.out.println(cc);
//
//        String sss = "厸";
//        System.out.println(sss.length());



        Integer a = 127;
        Integer b = 127;    // Integer 有Integer.cache缓存
        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        Integer.parseInt("+434");
        System.out.println(c == d);
    }
}