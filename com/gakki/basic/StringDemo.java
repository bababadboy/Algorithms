package com.gakki.basic;

/**
 * Java字符串的比较
 * @author wangxiaobin
 */
public class StringDemo {
    public static void main(String[] args) {
        String s2 = new String("Hello World"); // idea⚠️，不常用，会有性能问题
        String s1 = "Hello World";
        System.out.println(s1 == s2);       // false
        System.out.println(s1.equals(s2));  // true

    }

}
