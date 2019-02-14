package com.gakki.chapter2.sortingUtility;

import java.util.Random;
/**
 * @author wangxiaobin
 */
public class Util {
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
        for (Comparable item:a
             ) {
            System.out.print(item + "\t");
        }

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
