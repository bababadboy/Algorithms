package com.gakki.leetcode.T_59;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
        int[][] a = generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int colMax = n - 1;
        int rowMax = n - 1;
        int colMin = 0;
        int rowMin = 0;

        // 初始化默认为0
        int[][] a = new int[n][n];
        int m = 1;
        while (true){
            // 上边
            for (int j = colMin; j <= colMax; j ++)
                a[colMin][j] = m ++;
            rowMin ++;
            if (colMax < colMin || rowMax < rowMin)
                break;
            // 右边
            for (int i = rowMin; i <= rowMax; i ++)
                a[i][colMax] = m ++;
            colMax --;
            if (colMax < colMin || rowMax < rowMin)
                break;
            // 下边
            for (int j = colMax; j >= colMin; j --)
                a[rowMax][j] = m ++;
            rowMax --;
            if (colMax < colMin || rowMax < rowMin)
                break;
            // 左边
            for (int i = rowMax; i >= rowMin; i--)
                a[i][colMin] = m ++;
            colMin ++;
            if (colMax < colMin || rowMax < rowMin)
                break;
        }


        return a;
    }
}
