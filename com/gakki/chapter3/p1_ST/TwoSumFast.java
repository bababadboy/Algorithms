package com.gakki.chapter3.p1_ST;

import java.util.Arrays;

/**
 * 两数之和，时间复杂度为:nlogn；优化了暴力查找的 n^2
 * @author wangxiaobin
 */
public class TwoSumFast {

    public static int count(int[] a){
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            int search = BinarySearch.search(a,-a[i]);
            if (search > i){
                // 判断条件，避免重复
                cnt ++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = new int[]{2,4,-2,5,9,0,-3,-4};
        System.out.println("TwoSum:"+count(a));
    }
}
