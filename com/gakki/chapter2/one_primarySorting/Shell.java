package com.gakki.chapter2.one_primarySorting;


import static com.gakki.chapter2.sortingUtility.Utlity.*;

/**
 * @author wangxiaobin
 * 希尔排序对h序列的排序方式采用了Exch的插入（冒泡）方法，可以优化成"整体后移法"
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;  // 初始化h序列，h的值
        while (h < N/3) h = h*3+1;    // 找到合适大小的h值，除号类似 i < n-1 中的减号
        while (h >= 1) {
            for (int i = h; i < N; i++) {   // 从a[]的第h个元素开始，a[h],a[h+1],a[h+2]..a[N-1]
                for (int j = i;j >= h && less(a,j,j-h); j -= h) {   // exchange高端小的元素到低端，增量为h
                    exch(a,j,j-h);
                }
            }
            h = h /3;
        }

    }

    public static void main(String[] args) {
        String s[] = {"S","H","E","L","L","S","O","R","T","E","X","A","M","P","L","E"};
        sort(s);
        for (int i = 0; i < s.length; i ++){
            System.out.print(s[i]);
        }
    }
}
