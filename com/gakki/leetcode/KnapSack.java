package com.gakki.leetcode;

/**
 * 0/1 背包问题
 * @author wangxiaobin
 */
public class KnapSack {
    public static void main(String[] args) {
        int N = 5;  // 共有5件商品
        int W = 20; // 背包大小

        int[] weight = {0, 2, 3, 4, 5, 9};  // 第0个设为0
        int[] val = {0, 3, 4, 5, 8, 10};     // 第0个设为0

        int maxVal = B_Recursive(weight, val, N, W);
        int maxValWithOutRecursive = B(weight, val, N, W);

        System.out.println(maxVal);
        System.out.println(maxValWithOutRecursive);

    }

    /**
     * 非递归实现背包，保存至二维数组
     * @param n 商品个数
     * @param w 剩余背包大小
     */
    private static int B(int[] weight, int[] val, int n, int w) {
        int[][] arr = new int[n+1][w+1];

        // 按公式顺序填写二维数组，第0行，和第0列均为0
        // i ==> 商品
        for (int i = 1; i < n + 1; i++) {
            // j ==> 背包大小
            for (int j = 1; j < w + 1; j++) {
                // 如果重量大于 背包大小，则赋值为上一行的值
                if (weight[i] > j)
                    arr[i][j] = arr[i-1][j];
                else {
                    // 选or不选 选择其中更大的
                    int notChoose = arr[i -1][j];
                    int choose    = val[i] + arr[i-1][j-weight[i]];
                    arr[i][j] = Math.max(notChoose,choose);
                }
            }
        }

        return arr[n][w];

    }


    /**
     * 在w的情况下，存在1~n号商品，能获得最大的val
     * @param n 商品个数
     * @param w 背包剩余大小
     * 递归实现
     */
    private static int B_Recursive(int[] weight, int[] val, int n, int w) {
        if (n == 0)
            return 0;
        // 如果 第weight_n 超过了 w,则不选 n
        if (weight[n] > w)
            return B_Recursive(weight,val,n-1,w);
        else {
            int chooseN = val[n] + B_Recursive(weight,val,n-1,w-weight[n]);
            int notChooseN = B_Recursive(weight,val,n-1,w);

            return Math.max(chooseN,notChooseN);
        }
    }


}
