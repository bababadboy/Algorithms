package com.gakki.leetcode.T_807;

/**
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[4][];

    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // 行最大值
        int[] rowsMax = new int[row];
        for (int i = 0; i < row; i++) {
            int rowMax = 0;
            for (int j = 0; j < col; j++) {
                if (grid[i][j] > rowMax){
                    rowMax = grid[i][j];
                }
            }
            // 把每行的最大值赋值给rowsMax
            rowsMax[i] = rowMax;
        }
        // 列最大值
        int[] colsMax = new int[col];
        for (int j = 0; j < col; j ++) {
            int colMax=0;
            for (int i = 0; i < row; i++) {
                if (grid[i][j] > colMax) {
                    colMax = grid[i][j];
                }
            }
            colsMax[j] = colMax;
        }

        int[][] newGrid = new int[row][col];
        int incrsd = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                incrsd += (min(rowsMax[i],colsMax[j]) - grid[i][j]);
            }
        }
        return incrsd;
    }

    private int min(int a, int b){
        if (a <= b)
            return a;
        return b;
    }
}
