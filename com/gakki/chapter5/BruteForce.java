package com.gakki.chapter5;

/**
 * @author wangxb (O_o)??)
 * @date 2019-07-04
 * 暴力字符串匹配算法
 */
public class BruteForce {
    public static void main(String[] args) {
        String s = "abcacabdc";
        String pattern = "abd";
        int idx = search(s,pattern);
        System.out.println(pattern+"在"+s+"中的位置是:"+idx);
    }

    /**
     * BruteForce字符串匹配
     * @param s 主串
     * @param pattern 模式串
     * @return  返回模式串与主串匹配的头字符的下标，灭有则返回-1
     */
    private static int search(String s, String pattern) {

        int m = s.length();
        int p = pattern.length();

        //  模式串长度长于主串,则不可能匹配
        if (p > m){
            return -1;
        }
        int i = 0;  // 模式串头在主串的下标
        while (i < m - p + 1){
            for (int j = 0; j < p; j++) {
                if (pattern.charAt(j) != s.charAt(i + j)){
                    // 不匹配则往后移一个字符
                    i ++;
                    break;
                }
                if (j == p - 1){
                    return i;
                }
            }
        }
        return -1;
    }

}
