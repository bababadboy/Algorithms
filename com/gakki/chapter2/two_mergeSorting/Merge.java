package com.gakki.chapter2.two_mergeSorting;
import static com.gakki.chapter2.sortingUtility.Utlity.*;


/**
 * @author wangxiaobin
 */
public class Merge {

    private static Comparable[] aux;

    public static void merge(Comparable[] a ,int lo, int mid, int hi) {
//        Comparable[] aux  = new  Comparable[a.length];  // 辅助数组
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k ++) {   // 将a复制到aux，必须是 k <= hi,否则只有一个元素
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k ++) {   // 注意等号，从a[lo]..a[hi]都要归并
            if (i > mid) a[k] = aux[j++];   // 左半边用完
            else if (j > hi) a[k] = aux[i++];    // 右半边用完,必须要用esle if啊！！
            else if (less(aux,i,j)) a[k] = aux[i++]; // 左边更小,必须要用esle if啊！！
            else a[k] = aux[j++];               // 右边更小

        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if (hi <= lo) return;       // 等号必须要加上去
        int mid = lo + (hi - lo) / 2;
        // 递归调用
        sort(a,lo,mid); // 归并左边
        sort(a,mid+1,hi); //归并右边
        merge(a,lo,mid,hi);
    }

    public static void main(String[] args) {
        String s[] = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
        sort(s);
        print(s);
    }

}
