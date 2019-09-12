package com.gakki.leetcode.problemset.algorithms.T_46;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/comments/
 * @author wangxiaobin
 */
public class Solution {
    private List<Integer> list;
    private List<List<Integer>> listList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        /*
        1,2,3做全排列
        ============>
        1 ... // 以1 为首
        2 ... // 以2 为首
        3 ... // 以3 为首
         */
        perm(nums,0,nums.length-1);
        return listList;
    }

    private void perm(int[] nums, int start, int end) {
        if (start == end){
            list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            listList.add(list);
            return;
        }
        // 主体
        for (int i = start; i <= end; i++) {
            swap(nums,i,start);
            perm(nums,start+1,end);
            swap(nums,i,start);
        }

    }

    private void swap(int[] nums, int start, int i) {
        if (i == start){
            return;
        }
        int tmp = nums[start];
        nums[start] = nums[i];
        nums[i] = tmp;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Solution s = new Solution();
        s.permute(arr);
    }

}
