package com.gakki.leetcode.questions_easy.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author wangxb XD
 * @date 2019-09-18
 */
public class TwoSum {
    public int[] twoSumSlow(int[] nums, int target){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public int[] twoSum(int[] nums, int target) {
        // 存储
        Map<Integer,Integer> tracker = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (tracker.containsKey(nums[i])){
                return new int[]{tracker.get(nums[i]),i};
            }else {
                tracker.put(target-nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }


    public static void main(String[] args) {
        int[] arr = new TwoSum().twoSum(new int[]{2, 4, 3},6);
        int a  = 1;
    }
}
