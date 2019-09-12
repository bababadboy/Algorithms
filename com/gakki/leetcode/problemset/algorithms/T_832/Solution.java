package com.gakki.leetcode.problemset.algorithms.T_832;

/**
 * https://leetcode-cn.com/problems/flipping-an-image/
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
            };
        arr = flipAndInvertImage(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static int[][] flipAndInvertImage(int[][] A) {
        int rows = A[0].length;
        int cols = A.length;
        int[][] res = new int[rows][cols];
        // 图片翻转
        for (int i = 0; i < rows; i++) {
            for (int j = cols -1; j >= 0; j--) {
                res[i][cols-1 - j] = A[i][j];
            }
        }
        // 图片反转
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = res[i][j]== 0?1:0;
            }
        }
        return res;
    }
}
