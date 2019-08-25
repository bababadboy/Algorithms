package com.gakki.Algroithms4th.chapter2.p3_quickSorting;

import static com.gakki.Algroithms4th.chapter2.sortingUtility.Util.*;
/**
 * @author wangxiaobin
 */
public class Quick {
    public static void sort(Comparable[] a) {
        shuffle(a);
//        print(a);
        sort(a,0,a.length-1);
    }

    /**
     * 递归快速排序
     * @param a 待排数组
     * @param lo 低端索引
     * @param hi 高端索引
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;

        /* 这里相当与书上的partion(a,lo,hi)方法*/
        int i = lo;
        int j = hi+1;
        while (i < j) {
            while (less(a,++i,lo))
                if (i == hi)
                    break;
            while (less(a,lo,--j))
                if (j == lo)
                    break;
            if (i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);   // 把切分元素a[lo]放置到合理的位置
        /*partion()结束*/

        sort(a,lo,j-1);    //
        sort(a,j+1,hi);

    }


    public static void main(String[] args) {
        String s[] = {"Q","U","I","C","K","S","O","R","T","E","X","BaseA","M","P","L","E"};
        sort(s);
        print(s);
    }
}
