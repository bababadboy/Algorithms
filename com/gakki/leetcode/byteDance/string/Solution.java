package com.gakki.leetcode.byteDance.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 思路：
 * 设两个指针。head,tail,移动找规律。想想自己不用程序，怎么找到的，然后一般化规律形成规则。
 * @author wangxiaobin
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // 最长无重复字符的头(head)和尾(tail)
        int maxLen = 0;
        char[] chs = s.toCharArray();

        int head = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < chs.length; i ++) {
            if(!map.containsKey(chs[i])) {
                if(i - head + 1 > maxLen) {
                    maxLen = i - head + 1;
                }
            }else {
                head = Math.max(map.get(chs[i]) + 1,head);
                if(i - head + 1 > maxLen) {
                    maxLen = i - head + 1;
                }
            }
            map.put(chs[i],i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
//        assert (lengthOfLongestSubstring("abcabcbb") != 3) : "'abcabcab' is wrong!";
//        assert  (lengthOfLongestSubstring("pwwkew") != 3) : "'pwwkew' is wrong, either!";
//        assert  (lengthOfLongestSubstring("bbbbb") != 1): "'bbbbb' is also wrong!";
    }
}
