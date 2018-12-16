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
                head = Math.max(hashMap.get(s.charAt(i)) + 1,head); //

                if (i - head + 1 > len) {
                    len = i - head + 1;
                }
            }
            hashMap.put(s.charAt(i),i);
        }
        return len;
    }
}
