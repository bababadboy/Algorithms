package com.gakki.leetcode.questions_easy.dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票
 * @author wangxb XD
 * @date 2019-09-12
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int hi = prices.length - 1;
        return opt(prices,hi);
    }

    private int opt(int[] arr, int hi) {
        if (hi == 1){
            int prof =  arr[1] - arr[0];
            return prof < 0 ? 0: prof;
        }
        // 第hi天卖出
        int sellProf = arr[hi] - min(arr,0,hi-1);
        // 第hi天不卖出
        int notSellProf = opt(arr,hi-1);
        int maxProf = Math.max(sellProf,notSellProf);
        return maxProf< 0  ?0: maxProf;
    }

    private int min(int[] arr, int from, int to) {
        int min = arr[from];
        for (int i = from+1; i <= to; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * 动态规划思想
     */
    public int maxProf(int[] prices) {
        int min = prices[0];
        int max = 0;    // max profit
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return  max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
//        int[] arr = new int[]{7,6,4,3,1};

        System.out.println(new MaxProfit().maxProfit(arr));
        System.out.println(new MaxProfit().maxProf(arr));
    }
}
