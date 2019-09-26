package com.gakki.leetcode.questions_middle.array_and_string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxb XD
 * @date 2019-09-24
 */
public class LongestSubstr {

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int head = 0;
        int len = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i]) && map.get(chars[i]) >= head){   // 已存在字符
                head = map.get(chars[i]) + 1;
            }else{
                len = Math.max(len,i - head + 1);
            }
            map.put(chars[i],i);
        }
        return len;

    }


    public static void main(String[] args) {
        int a = new LongestSubstr().lengthOfLongestSubstring("tmmzuxt");
        System.out.println(a);
    }
}
