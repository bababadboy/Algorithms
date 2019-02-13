package com.gakki.chapter2.sortingUtility;

/**
 * @author wangxiaobin
 */
public class Utlity {
    public static boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }
    public static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void print(Comparable[] a) {
        if (a.length == 0) return;
        for (int i = 0 ; i < a.length; i ++){
            System.out.print(a[i]+"\t");
        }

    }
}
