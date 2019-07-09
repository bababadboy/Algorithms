package com.gakki.leetcode;

import java.util.HashMap;

/**
 * @author wangxiaobin
 */
public class StringSolution {
    public static void main(String[] args) {
        String txt = "abcaaab";
        String pat = "aab";
        System.out.println("匹配的位置是："+search(pat,txt));
    }

    /**
     * 暴力搜索在txt中是否存在pat
     * @param pat 模式
     * @param txt 文本
     * @return pat在txt中的位置，不存在则返回-1
     */
    public static int search(String pat, String txt){
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i < N; i ++){
            int j;
            for (j = 0; j < M; j ++){
                if (pat.charAt(j) != txt.charAt(i+j)){
                    break;
                }
            }
            if (j == M){
                return i;
            }
        }
        return -1;
    }


    /**
     * 寻找最长无重复子串长度
     * @param s 字符串
     * @return 最长无重复子串长度
     */
    public static int lengthOfLongestSubstring(String s){
        int len = 0;
        // head是最长无重复子串的起始位置
        int head = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>(); // <字符，位置>

        for (int i = 0; i < s.length(); i++){
            if (!hashMap.containsKey(s.charAt(i))){ // 不包含重复的键
                if (i - head + 1 > len) {
                    len = i - head + 1;
                }

            }
            else { // 出现了重复字符
                head = Math.max(hashMap.get(s.charAt(i)) + 1,head); // 如果重复字符的位置小于现在的head，则head仍未现在的head

                if (i - head + 1 > len) {
                    len = i - head + 1;
                }
            }
            hashMap.put(s.charAt(i),i);
        }
        return len;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     */
    public static String longestCommonPrefix(String[] strs){
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i  = 1; i < strs.length; i ++){    // 两两比较prefix
            int j = 0;  // 前缀的最后一个字母的position
            while (j < prefix.length() && j < strs[i].length() && strs[i].charAt(j)==prefix.charAt(j)){
                j ++;
            }
            if (j == 0)
                return "";
            prefix = prefix.substring(0,j); // 更新prefix

        }

        return prefix;
    }

}
































