package com.gakki.leetcode.questions_easy.tree;

import java.util.LinkedList;

/**
 * 验证二叉树是否是儿茶搜索树
 * @author wangxb (O_o)??)
 * @date 2019-09-10
 */
public class VerifyBST {

    /**
     * 中序遍历得到的数据是否递增判断
     */
    private LinkedList<Integer> list= new LinkedList<>();
    public  boolean isValidBST(TreeNode root) {
        midOrder(root);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    private int lastVal;
    private  void midOrder(TreeNode root) {
        if (root == null){
            return;
        }
        midOrder(root.left);
        list.add(root.val);
        midOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        VerifyBST v= new VerifyBST();
        System.out.println(v.isValidBST(root));
    }
}
