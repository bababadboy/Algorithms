package com.gakki.basic;

/**
 * Java字符串的比较
 * @author wangxiaobin
 */
public class StringDemo {
    public static void main(String[] args) {
//        String s2 = new String("Hello World"); // idea⚠️，不常用，会有性能问题
//        String s1 = "Hello World";
//        System.out.println(s1 == s2);       // false
//        System.out.println(s1.equals(s2));  // true


        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);           // false
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s4);           // true
    }

}
