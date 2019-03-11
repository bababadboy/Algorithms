package com.gakki.chapter3.p1_ST;

import java.util.Arrays;

/**
 * 二分查找（基于有序数组）
 *
 * @author wangxiaobin
 */
public class BinarySearch {
    public static int search(int [] pq,int a){
        int low = 0;
        int hi = pq.length - 1;
        int mid = low + (hi - low) /2;
        while (low <= hi){
            if (a == pq[mid]){
                return mid;
            }
            if (a > pq[mid]) {
                low = mid + 1;
            }
            if (a < pq[mid]) {
                hi = mid - 1;
            }
            mid = low + (hi - low) / 2;
        }
        return -1;
    }

}
