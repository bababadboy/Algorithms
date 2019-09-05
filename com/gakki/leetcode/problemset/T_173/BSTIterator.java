package com.gakki.leetcode.problemset.T_173;


import com.gakki.leetcode.problemset.T_938.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * 二叉排序树时间复杂度为o(1)的迭代器
 * @author wangxiaobin
 */

public class BSTIterator {

    // 前驱后继节点存放
    private Queue<TreeNode> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inorder(root);
    }

    private void inorder(TreeNode root){
        if (root == null)
            return;
        inorder(root.left);
        queue.offer(root);
        inorder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll().val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */

    public static void main(String[] args) {

    }
}
