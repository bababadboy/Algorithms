package com.gakki.leetcode.problemset.algorithms.T_771;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/
 * @author wangxiaobin
 */
public class Solution {

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(new Solution().numJewelsInStones(J,S));
    }
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        Set<Character> setJ = new HashSet<>();
        List<Character> listS = new ArrayList<>();
        // 把 J 和 S 中的字符加到中存储结构中
        for (int i = 0; i < J.length(); i++) {
            setJ.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            listS.add(S.charAt(i));
        }

        for (char ch: listS
             ) {
            if (setJ.contains(ch)) {
                cnt ++;
            }
        }

        return cnt;
    }
}
