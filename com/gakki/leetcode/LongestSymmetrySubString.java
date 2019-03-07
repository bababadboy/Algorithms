package com.gakki.leetcode;


import java.util.Scanner;

/**
 * 最长对称子串（完成所有用例测试）
 * @author wangxiaobin
 */
public class LongestSymmetrySubString {
    public static void main(String[] args){
        // 终端输入，注意包路径java.util.Scanner
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // 默认为"最长对称子串"为第一个字符。
        String maxString = s.substring(0,1);

        // 暴力循环寻找
        for (int i = 0; i < s.length(); i ++) {
            int len = 1;
            for (int j = i + 1; j < s.length(); j ++) {
                int mid = i + (j - i) / 2;
                String left;
                String right;
                if ((j - i + 1) % 2 != 0) {
                    // 长度为基数的情况，mid所对应的是对称点，不需要比较
                    left = s.substring(i,mid);
                    right = s.substring(mid+1,j+1);
                }
                else {
                    left = s.substring(i,mid+1);
                    right = s.substring(mid+1,j+1);
                }
                if (left.equals(reserve(right))) {
                    len = j - i + 1;
                }
                if (len > maxString.length()){
                    maxString = s.substring(i,j+1);
                }
            }
        }
        System.out.println(maxString);
    }

    /**
     * 反转str
     * @param str 需要反转的字符创
     * @return str反转后的字符串
     */
    private static String reserve(String str){
        int len = str.length();
        char[] chars = new char[len];
        for (int i = 0; i < len; i++){
            chars[len - 1 - i] = str.charAt(i);
        }
        return new String(chars);
    }
}
