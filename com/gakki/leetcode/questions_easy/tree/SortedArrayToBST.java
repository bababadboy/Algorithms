package com.gakki.leetcode.questions_easy.tree;

/**
 * @author wangxb XD
 * @date 2019-09-11
 */
public class SortedArrayToBST {

    private TreeNode sortedArrayToBST(int[] nums){
        int len = nums.length;
        TreeNode root = new TreeNode(nums[len/2]);
        // 左半边
        binary(nums,0,len/2-1,root);
        // 右半边
        binary(nums,len/2+1,len-1,root);
        return root;
    }

    private void binary(int[] nums, int lo, int hi, TreeNode root) {
        if (hi < lo){
            return;
        }
        int mid = lo + (hi - lo) /2;
        TreeNode node = new TreeNode(nums[mid]);

        int compare = compare(root,node);
        if (compare > 0){
            root.left = node;
        }
        else {
            root.right = node;
        }

        binary(nums,lo,mid-1,node);
        binary(nums,mid+1,hi,node);
    }

    private int compare(TreeNode n1, TreeNode n2) {
        return n1.val-n2.val;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-15,-10,-5,-3,0,3,8,10,12};
        TreeNode root= new SortedArrayToBST().sortedArrayToBST(arr);
        midOrder(root);
    }

    private static void midOrder(TreeNode root) {
        if (root == null){
            return;
        }
        midOrder(root.left);
        System.out.println(root.val);
        midOrder(root.right);
    }
}
