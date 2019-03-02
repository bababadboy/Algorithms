package com.gakki.basic;

import java.util.Random;

/**
 * @author wangxiaobin
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "bbb";
        String s3 = s1 + s2;
        String s4 = "aaabbb";
        System.out.println(s3 == s4); // false
    }
}
