package com.gakki.leetcode.questions_easy.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @author wangxb XD
 * @date 2019-09-17
 */
public class MoveZeroes {
    // 冒泡移动
    public void moveZeroes(int[] nums) {
        int cntZero = 0;    // 末尾0的个数
        // 从后向前遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0){
                // 从后往前覆盖
                int j = i;
                for (; j < nums.length - 1 - cntZero; j ++) {
                    nums[j] = nums[j+1];
                }
                nums[j] = 0;
                cntZero ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,0,8,0,6};
        new MoveZeroes().moveZeroes(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
