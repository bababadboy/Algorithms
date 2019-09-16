package com.gakki.leetcode.questions_easy.array;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 * @author wangxb (O_o)??)
 * @date 2019-09-05
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(a);
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
        int[] b = {0,0,1,1,1,2,2,3,3,4};
        int len2 = removeDuplicates2(b);
        for (int i = 0; i < len2; i++) {
            System.out.print(b[i] + "\t");
        }
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        if (nums.length == 0){
            return 0;
        }
        int record = 1;     // 不重复的长度
        for (int i = 0,j = i + 1; j < nums.length; i++,j++) {
            if (nums[i] != nums[j]){
                nums[record] = nums[j];
                record ++;
            }
        }
        return record;
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
