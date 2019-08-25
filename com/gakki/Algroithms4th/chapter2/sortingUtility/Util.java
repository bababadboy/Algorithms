package com.gakki.Algroithms4th.chapter2.sortingUtility;

import java.util.Random;
/**
 * @author wangxiaobin
 */
public class Util {
    public static boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }

    /**
     * 堆排序时使用
     */
    public static boolean less2(Comparable[] a, int i, int j){
        return a[i-1].compareTo(a[j-1]) < 0;
    }
    public static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * 堆排序时使用
     */
    public static void exch2(Comparable[] a, int i, int j) {
        Comparable tmp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = tmp;
    }
    public static void print(Comparable[] a) {
        if (a.length == 0) return;
        for (Comparable item:a
             ) {
            System.out.print(item + "\t");
        }
        System.out.println();

    }

    /**
     * 随机打乱数组，详情见 https://blog.csdn.net/qq_33256688/article/details/80304048
     * @param a 需要打乱的数组
     */
    public static void shuffle(Comparable[] a) {
        Random random = new Random();
        int length = a.length;
        for ( int i = length; i > 0; i --) {
            int randInd = random.nextInt(i);
            exch(a, randInd, i - 1);
        }
    }
}
