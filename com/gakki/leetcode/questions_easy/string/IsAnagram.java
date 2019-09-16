package com.gakki.leetcode.questions_easy.string;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * @author wangxb XD
 * @date 2019-09-15
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] sCnt = new int[26];
        int[] tCnt = new int[26];

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        // 统计s和t的字符个数
        for (int i = 0; i < schars.length; i++) {
            sCnt[schars[i] - 'a'] += 1;
            tCnt[tchars[i] - 'a'] += 1;
        }

        // 比较s和t的字符个数
        for (int i = 0; i < sCnt.length; i++) {
            if (sCnt[i]!=tCnt[i]){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        new IsAnagram().isAnagram("anagram","nagaram");
    }
}
