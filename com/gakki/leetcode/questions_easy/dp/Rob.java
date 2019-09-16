package com.gakki.leetcode.questions_easy.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * @author wangxb XD
 * @date 2019-09-12
 */
public class Rob {
    HashMap<Integer,Integer> opt = new HashMap<>();

    /**
     * 运行时间超时
     */
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        return opt(nums,nums.length-1);
    }

    private int opt(int[] arr, int hi) {

        if (hi == 1){
            return Math.max(arr[1],arr[0]);
        }
        if (hi == 0){
            return arr[0];
        }
        return Math.max(arr[hi]+ opt(arr,hi-2),opt(arr,hi-1));
    }

    /**
     *  空间换时间
     */
    public int rob2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        opt[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            opt[i] = Math.max(nums[i]+opt[i-2],opt[i-1]);
        }
        return opt[opt.length-1];
    }

    /**
     * 优化rob2的空间复杂度n -> 常数,opt1,opt2存储两个最优子解~~
     */
    public int rob3(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int opt1 = nums[0];
        int opt2 = Math.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int t = Math.max(nums[i]+opt1,opt2);
            opt1 = opt2;
            opt2 = t;
        }
        return opt2;
    }

    public static void main(String[] args) {
        System.out.println(new Rob().rob3(new int[]{6,6,4,8,4,3,3,10}));
    }
}
