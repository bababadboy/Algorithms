package com.gakki.leetcode.problemset.algorithms.T_90;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * 思路：
 * 1. 初始化res，并添加首个元素——空集
 * 2. 遍历nums，遍历res,把nums[i]和res[j]合并添加到res的新元素
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,1,2,2};
        s.subsetsWithDup(a);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int N = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>()); // 添加一个空元素
        for (int i = 0; i < N; i++) {
            // 遍历动态增长的res
            int M = res.size();
            for (int j = 0; j < M; j++) {
                // t存储多元素子集和单元素集（单元素集适合res.get(0)合并起来的，因为res.get(0) == null ）
                List<Integer> t = new ArrayList<>(res.get(j));
                t.add(nums[i]);
                if (!contains(res,t)){
                    res.add(t);
                }
            }
        }
        return res;
    }
    private boolean contains(List<List<Integer>> outList,List<Integer> inList){

        for (List<Integer> list :
                outList) {
            // 只要大小相同并且互相包含就相同（排除顺序因素）
            Collections.sort(list);
            Collections.sort(inList);
            boolean equals = true;
            if (list.size() != inList.size())
                equals = false;
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).equals(inList.get(i))){
                    equals = false;
                    break;
                }
            }
            if (equals)
                return true;
        }

        return false;
    }
}
