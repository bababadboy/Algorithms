package com.gakki.leetcode.T_110;

import com.gakki.leetcode.T_938.TreeNode;

/**
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root =new TreeNode(0);
        TreeNode t1 =new TreeNode(2);
        TreeNode t2 =new TreeNode(4);
        TreeNode t3 =new TreeNode(1);
        TreeNode t4 =new TreeNode(3);
        TreeNode t5 =new TreeNode(-1);
        TreeNode t6 =new TreeNode(5);
        TreeNode t7 =new TreeNode(1);
        TreeNode t8 =new TreeNode(6);
        TreeNode t9 =new TreeNode(8);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.right = t8;
        t5.right = t9;


        System.out.println(s.isBalanced(root));
    }

    private boolean mark;
    private boolean isBal;
    public boolean isBalanced(TreeNode root) {
        isBals(root);
        return isBal;
    }

    private boolean isBals(TreeNode root) {
        if(root == null)
        {
            mark = true;
            return mark;
        }
        isBals(root.left);
        isBals(root.right);
        int leftdepth = depth(root.left);
        int rightdepth = depth(root.right);

        mark = mark && (Math.abs(leftdepth - rightdepth) <= 1);
        if (!mark)
            isBal = false;
        return mark;
    }

    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right)) + 1;

    }
}
