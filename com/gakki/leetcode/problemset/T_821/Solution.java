package com.gakki.leetcode.problemset.T_821;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 * @author wangxiaobin
 */
public class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] chs = S.toCharArray();
        int len = chs.length;
        Set<Integer> idxSet = new HashSet<>();
        // 把C的各个位置存储起来
        for (int i = 0; i < len; i++) {
            if (chs[i] == C){
                idxSet.add(i);
            }
        }
        int[] shortestDists = new int[len];
        for (int i = 0; i < chs.length; i++) {
            // 每个字符的初始值都赋值为 len;
            int shortest = len;
            for (int a : idxSet) {
                int d = Math.abs(a -i);
                if (d < shortest){
                    shortest = d;
                }
            }
            shortestDists[i] = shortest;
        }
        return shortestDists;
    }
}
