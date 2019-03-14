package com.gakki.leetcode.T_709;

/**
 * https://leetcode-cn.com/problems/to-lower-case/
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(toLowerCase("Hggg"));
    }
    public static String toLowerCase(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if ( ch >= 'A' && ch <= 'Z') {
                ch |= 32;
            }
            chars[i] = ch;
        }
        return new String(chars);
    }
}
