package com.gakki.leetcode.questions_easy.array;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 * @author wangxb (O_o)??)
 * @date 2019-09-05
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] a = {1,1};
        int len = removeDuplicates(a);
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    public static int removeDuplicates(int[] nums) {
        // 记录非重复长度
        int uniqLen = nums.length;
        // 重复长度
        int dupCount = 0;

        for (int i = 0; i+1 < uniqLen; i++) {
            int j = i + 1;

            if (nums[i] == nums[j]){
                dupCount ++;
            }else{
                if (dupCount > 0){
                    // 向左移动dupCount格
                    System.arraycopy(nums, j, nums, j - dupCount,uniqLen - j);
                    uniqLen -= dupCount;
                    i -= dupCount;  // j 会在循环开始被改为 i + 1
                    dupCount = 0;   // 置为0
                }
            }
        }
        if (dupCount > 0){  // 不优雅的解决 [1,1],[2,3,3,3,3],[3,4,4,4]这类bug
            uniqLen -= dupCount;
        }
        return uniqLen;
    }
}
