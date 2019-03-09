package com.gakki.leetcode;

import java.util.*;

/**
 * @author wangxiaobin
 */
public class DrawChar {
    public static void main(String[] args) {
        char[] chars = new char[]{'a','b','c','a','b','a'};
        System.out.println(drawChar(chars));
    }

    public static char[] drawChar (char[] txt){
        Map<Character,Integer> char2Count = new HashMap<>();
        for(int i =0; i < txt.length; i ++){
            if(!char2Count.containsKey(txt[i])) {
                char2Count.put(txt[i],1);
            }
            else {
                int count = char2Count.get(txt[i]);
                count ++;
                char2Count.put(txt[i],count);
            }
        }
        int maxCount = 0;
        char maxChar = txt[0];
        for(char ch:char2Count.keySet()) {
            if (char2Count.get(ch) > maxCount) {
                maxCount = char2Count.get(ch);
                maxChar = ch;
            }
        }
        // 写入返回的结果集
        char[] res = new char[txt.length];
        for(int i = 0; i < maxCount; i ++) {
            res[i] = maxChar;
        }
        int size = maxCount;
        for(int i = 0; i < res.length; i ++){
            if(txt[i] == maxChar){
                continue;
            }
            res[size ++] = txt[i];
        }
        return res;
    }


}
