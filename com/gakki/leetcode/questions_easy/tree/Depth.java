package com.gakki.leetcode.questions_easy.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * @author wangxb (O_o)??)
 * @date 2019-09-10
 */
public class Depth {
    /**
     * 利用递归求深度
     */
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            // 叶子节点
            return 1;
        }
        if (root.left == null){
            return maxDepth(root.right) + 1;
        }
        if(root.right == null){
            return maxDepth(root.left) + 1;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }


    /**
     * 层次遍历求深度
     */
    public static int maxDepthByLevel(TreeNode root){
        if (root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode t = queue.peek();
                size --;
                if (t.left != null){
                    queue.offer(t.left);
                }
                if (t.right != null){
                    queue.offer(t.right);
                }
                queue.poll();
            }
            depth ++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;


        System.out.println(maxDepthByLevel(root));
    }
}
