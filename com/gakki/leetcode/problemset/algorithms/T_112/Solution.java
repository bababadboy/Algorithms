package com.gakki.leetcode.problemset.algorithms.T_112;

import com.gakki.leetcode.problemset.algorithms.T_938.TreeNode;

/**
 * @author wangxiaobin
 */
class Solution {
    private boolean has;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        preorder(root,sum);
        return has;
    }
    private void preorder(TreeNode root, int sum){
        if(root == null)
            return;
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0){
            has = true;
            return;
        }
        preorder(root.left,sum);
        preorder(root.right,sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eleven = new TreeNode(11);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);

        root.left = four;
        four.left = eleven;
        eleven.right = two;
        eleven.left = seven;

        Solution s = new Solution();
        System.out.println(s.hasPathSum(root,22));
    }
}
