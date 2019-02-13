package com.gakki.chapter2.two_mergeSorting;
import static com.gakki.chapter2.sortingUtility.Utlity.*;


/**
 * @author wangxiaobin
 */
public class Merge {

//    private Comparable[] aux = new Comparable[];

    public static void merge(Comparable[] a ,int lo, int mid, int hi) {
        Comparable[] aux  = new  Comparable[a.length];  // 辅助数组
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k < hi; k ++) {   // 将a复制到aux
            aux[k] = a[k];
        }

        for (int k = lo; k < hi; k ++) {
            if (i > mid) a[k] = aux[j++];   // 左半边用完
            if (j > hi) a[k] = aux[i++];    // 右半边用完
            if (less(aux,i,j)) a[k] = aux[i++]; // 左边更小
            else a[k] = aux[j++];               // 右边更小

        }
    }

    public static void sort(Comparable[] a) {
        sort(a,0,a.length-1);

    }
    private static void sort(Comparable[] a,int lo,int hi){
        int mid = lo + (hi - lo) / 2;
        if (lo > hi) return;
        // 递归调用
        sort(a,lo,mid); // 归并左边
        sort(a,mid+1,hi); //归并右边
        merge(a,lo,mid,hi);
    }

}
