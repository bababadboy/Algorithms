package com.gakki.chapter2.one_primarySorting;

/**
 * @author wangxiaobin
 * 希尔排序对h序列的排序方式采用了Exch的插入（冒泡）方法，可以优化成"整体后移法"
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;  // 初始化h序列，h的值
        while (h < N/3) h = h*3+1;    // 找到合适大小的h值，除号类似 i < n-1 中的减号
        while (h > 1) {
            for (int i = h; i < N; i++) {   // 从a[]的第h个元素开始，a[h],a[h+1],a[h+2]..a[N-1]
                for (int j = i; less(a,j,j-h) && j > 1; j -= h) {   // exchange高端小的元素到低端，增量为h
                    exch(a,i,j);
                }
            }
            h = h /3;
        }

    }
    private static boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        String s[] = {"S","H","E","L","L","S","O","R","T","E","X","A","M","P","L","E"};
        sort(s);
        System.out.print(s);
    }
}
