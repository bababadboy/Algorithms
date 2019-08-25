package com.gakki;

/**
 * 最长回文子串
 * @author wangxb XD
 * @date 2019-08-20
 */

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        String s = "daadbbdaadc";

        System.out.println("最长回文子串是："+ longestPalindromeSubstrViolent(s));

    }

    /**
     * 暴力解法
     */
    private static String longestPalindromeSubstrViolent(String s){
        int palindromeMaxLenMaybe = s.length();
        String baseStr = s.substring(0,1);
        // 长度从最长的s.length()开始
        for (int len = palindromeMaxLenMaybe; len > 0; len --) {
            for (int j = 0; j < s.length() - len + 1; j++) {
                String subStr = s.substring(j,j+len);
                if (judgePlindrome(subStr)){
                    return subStr;
                }
            }
        }
        return baseStr;
    }

    private static boolean judgePlindrome(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}