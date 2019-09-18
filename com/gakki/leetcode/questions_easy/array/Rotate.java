package com.gakki.leetcode.questions_easy.array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * @author wangxb XD
 * @date 2019-09-16
 */
public class Rotate {
    public void rotate(int[] nums, int k) {

        int step = k % nums.length;
        // 移动step次，每次向右移动一格
        for (int cnt = 1; cnt <= step; cnt ++){
            moveOneStep(nums);
        }
    }

    private void moveOneStep(int[] nums) {
        int lastNum = nums[nums.length-1];
        // 从后往前
        for (int i = nums.length-1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = lastNum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        new Rotate().rotate(arr,3);
        for (int i : arr) {
            System.out.print(i+"\t");
        }
    }

}
