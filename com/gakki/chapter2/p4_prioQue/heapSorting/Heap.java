package com.gakki.chapter2.p4_prioQue.heapSorting;
import static com.gakki.chapter2.sortingUtility.Util.*;
/**
 * 堆排序
 * 1. 基于swim():
 *  每添加一个新的元素，使用一次swim()
 * 2. 基于sink():
 *  当一个节点的子堆是堆有序时，在该节点调用sink()，能够让此节点为根节点的子堆也成为堆有序状态。（看这种话，要在脑子里想象画面）
 * @author wangxiaobin
 */
public class Heap {
    public static void sort(Comparable[] a) {
        // step1. 把堆修改成堆有序状态。（大顶堆）
        int N = a.length;
        for (int i = N/2; i >= 1; i --) {
            sink(a,i,N);
        }

        // step2. "删除"最大元素（与第一个元素交换），减少下沉范围 k = k - 1
        while (N >= 1) {
            exch2(a,1,N--);
            sink(a,1,N);
        }
    }

    /**
     * 下沉
     * @param a 下沉元素所在的堆
     * @param i 下层元素
     * @param k 下沉范围,[1,k]
     */
    private static void sink(Comparable[] a ,int i, int k) {
        while (2 * i <= k) {
            int j = 2 * i;
            // 确定左孩子和右孩子的大小
            if (j < k && less2(a,j,j+1)) {
                j ++;
            }
            // 和确定了的孩子交换
            if (less2(a,i,j)) {
                exch2(a,j,i);
            }
            i = j;
        }
    }
    public static void main(String[] args) {
        String s[] = {"H","E","A","P","S","O","R","T","E","X","A","M","P","L","E"};
        sort(s);
        print(s);
    }
}
