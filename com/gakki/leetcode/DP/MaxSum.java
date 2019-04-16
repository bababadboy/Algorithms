package com.gakki.leetcode.DP;

/**
 * 给一个整形数组，找出非相邻元素和的最大值。
 * 解析：dp问题，选还是不选角度思考
 * @author wangxiaobin
 */
public class MaxSum {
    public static void main(String[] args) {
        int[] arr = {1,2,4,1,7,8,3};
        int a = recOpt(arr,arr.length-1);
        System.out.println(a);
    }

    /**
     * dp实现，用数组存储递归的中间过程（空间换时间）
     */
    private static int dpOpt(int[] arr){
        // todo
        return 0;

    }

    /**
     * 递归方式实现
     * @return arr非相邻元素求和最大值
     */
    private static int recOpt(int[] arr, int i) {
        if (i == 0)
            return arr[0];
        else if (i == 1)
            return Math.max(arr[0],arr[1]);
        else {
            // 选arr[i]
            int a = arr[i] + recOpt(arr, i - 2);
            // 不选arr[i]
            int b = recOpt(arr,i - 1);
            return Math.max(a,b);
        }
    }

}
