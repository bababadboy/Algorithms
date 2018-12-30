package com.gakki;

import java.util.HashMap;

/**
 * @author wangxiaobin
 */
public class Solution {

    /**
     * 寻找最长无重复子串长度
     * @param s 字符串
     * @return 最长无重复子串长度
     */
    public static int lengthOfLongestSubstring(String s){
        int len = 0;
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

    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     *
     *
     * 示例2:
     *
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     *
     *
     * 注意：
     *
     * 输入的字符串只包含小写字母
     * 两个字符串的长度都在 [1, 10,000] 之间
     */
    public boolean checkInclusion(String s1, String s2){

    }

}
































