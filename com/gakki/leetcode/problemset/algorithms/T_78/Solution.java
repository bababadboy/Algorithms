package com.gakki.leetcode.problemset.algorithms.T_78;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,3,5,6};
        s.subsets(a);
    }

    public List<List<Integer>> subsets(int[] nums) {
        int N = nums.length;
        List<List<Integer>> llist = new ArrayList<>();
        llist.add(new ArrayList<>());   // 添加空元素

        for (int i = 0; i < N; i++) {
            int M = llist.size();

            for (int j = 0; j < M; j ++) {
                // t存储多元素子集
                List<Integer> t = new ArrayList<>(llist.get(j));
                t.add(nums[i]);
                llist.add(new ArrayList<>(t));
            }
        }

        return llist;
    }
}
