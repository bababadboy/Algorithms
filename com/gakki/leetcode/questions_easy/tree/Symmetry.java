package com.gakki.leetcode.questions_easy.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 验证二叉树是否是镜像二叉树
 * todo 未完成
 * @author wangxb (O_o)??)
 * @date 2019-09-10
 */
public class Symmetry {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return false;
        }
        return checkSymmetric(root.left,root.right);
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        // left的值等于right的值,并且left的左子树与right的柚子树对称，left的柚子树与right的左子树对称
        return left.val == right.val
                && checkSymmetric(left.left,right.right)
                && checkSymmetric(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);
//        TreeNode node6 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
//        node1.right = node4;
        node2.left = node5;
//        node2.right = node6;

        System.out.println(new Symmetry().isSymmetric(root));

    }
}
