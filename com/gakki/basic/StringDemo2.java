package com.gakki.basic;


/**
 * @author wangxiaobin
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "bbb";
        String s3 = s1 + s2;
        String s4 = "aaa" + "bbb";
        String s5 = "aaabbb";
        System.out.println(s4 == s5);
        System.out.println(equal(s4));
        System.out.println(equal(s3)); // false
        System.out.println(s3 == s4); // false
    }
    public static boolean equal(String str){
        return str == "aaabbb";
    }
}
