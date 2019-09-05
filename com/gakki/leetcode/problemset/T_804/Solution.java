package com.gakki.leetcode.problemset.T_804;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
        String[] strs = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(strs));
    }
    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
                "..-","...-",".--","-..-","-.--","--.."};
        int len = words.length;
        String[] morseWords = new String[len];

        for (int i = 0; i < len; i++) {

            char[] chs = words[i].toCharArray();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < chs.length; j++) {
                int idx = chs[j] - 'a';
                sb.append(morseCode[idx]);
            }
            morseWords[i] =  sb.toString();
        }

        Set<String> strSet = new HashSet<>();

        for (String word :
                morseWords) {
            strSet.add(word);
        }

        return strSet.size();

    }
}
