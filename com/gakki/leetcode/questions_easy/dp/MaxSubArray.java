package com.gakki.leetcode.questions_easy.dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @author wangxb XD
 * @date 2019-09-12
 */
public class MaxSubArray {

    /**
     * 暴力，超时
     */
    public int maxSubArrayBaoLi(int[] nums) {
        int max = nums[0];
        for (int sublen = 1; sublen <= nums.length; sublen ++){
            for (int j = 0; j <= nums.length-sublen; j++) {
                int sum = 0;
                for (int i = j; i < j+sublen; i++) {
                    sum += nums[i];
                }
                if (sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }


    /**
     * 动态规划思想
     * 从头开始遍历数组。
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int seq = nums[0];
        int max = nums[0];
        int i = 1;
        // 从正数开始
        for (; i < nums.length; i++) {
            if (seq > 0){
                seq += nums[i];
            }else{
                if (nums[i] > 0){
                    seq = nums[i];
                }else {
                    seq = Math.max(seq,nums[i]);
                }
            }
            max = Math.max(seq,max);
        }
        return max;
    }


    public static void main(String[] args) {
        int a = new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        int b = new MaxSubArray().maxSubArray(new int[]{1,-1,1});
        System.out.println(a);
        System.out.println(b);
    }
}
