package com.gakki.leetcode.T_654;

/**
 * @author wangxiaobin
 */

class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums,0,nums.length-1);
    }

    private TreeNode maxTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndx = findMax(nums,left,right);
        TreeNode root = new TreeNode(nums[maxIndx]);
        root.left = maxTree(nums,left,maxIndx - 1);
        root.right = maxTree(nums,maxIndx + 1,right);
        return root;
    }

    private int findMax(int[] nums, int left, int right) {
        if (left > right){
            throw  new IllegalArgumentException();
        }
        int max = nums[left];
        int maxIndx = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max){
                max = nums[i];
                maxIndx = i;
            }
        }
        return maxIndx;
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,6,0,5};
        Solution s = new Solution();
        System.out.println(s.constructMaximumBinaryTree(a).val);
    }
}