package com.gakki.basic;

import java.util.Random;

/**
 * @author wangxiaobin
 */
public class StringDemo3 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            int ss = new Random().nextInt();
            s.append(ss);
        }
        System.out.println(s);

    }
}
