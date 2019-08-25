package com.gakki.Algroithms4th.chapter3.p1_ST;

import java.util.Arrays;

/**
 * 三数之和，时间复杂度：O(n^2logn)，优化了暴力查找的O(n^3)
 * @author wangxiaobin
 */
public class ThreeSumFast {
    public static int count(int[] a){
        Arrays.sort(a);
        int cnt = 0;
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j ++){
                if (BinarySearch.search(a,-a[i]-a[j]) > j) {
                    cnt ++;
                }
            }

        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = new int[]{-1,0,1,2,-1,-4};
        System.out.println(count(a));
    }
}
