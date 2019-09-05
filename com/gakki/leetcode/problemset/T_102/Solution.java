package com.gakki.leetcode.problemset.T_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/comments/
 * 利用队列实现二叉树的层次遍历
 * @author wangxiaobin
 */
public class Solution {
    class TreeNode{
        int val;
        TreeNode left,right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ll = new ArrayList<>();

        queue.add(root);
        List<Integer> l = new ArrayList<>();
        while (!queue.isEmpty()){
            int cnt = queue.size();
            while (cnt > 0){
                TreeNode p = queue.poll();
                cnt --;
                l.add(p.val);
                if (p.left != null)
                {
                    queue.add(p.left);
                }
                if (p.right != null)
                {
                    queue.add(p.right);
                }
            }
            ll.add(l);

        }

        return ll;
    }
}