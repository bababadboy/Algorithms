package com.gakki.leetcode.questions_middle.array_and_string;

/**
 * 最长回文子串
 * @author wangxb XD
 * @date 2019-09-24
 */
public class LongestPalindrome {

    /**
     * ，中心扩展法
     */
    public String longestPalindrome(String s) {

        if ("".equals(s)){
            return "";
        }
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }

        String exStr = sb.toString();
//        char[] chars = exStr.toCharArray();
        int maxLen = 1;
        String longestStr = s.substring(0,1);
        for (int i = 1; i <= exStr.length() - maxLen/2; i++) {
            int lenAti = 1; // 中心为i 的字符串长度
            for (int radius = 1; i -radius >= 0 && i + radius < exStr.length(); radius ++) {
                if (exStr.charAt(i - radius) == exStr.charAt(i + radius)){
                    lenAti += 2;
                    if (lenAti > maxLen){
                        maxLen = lenAti;
                        longestStr = exStr.substring(i-radius,i+radius+1);
                    }
                }else {
                    break;
                }
            }
        }

        return longestStr.replace("#","");
    }

    public static void main(String[] args) {
        String res = new LongestPalindrome().longestPalindrome("abbcdbbd");
        System.out.println(res);
    }
}
