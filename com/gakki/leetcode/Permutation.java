package com.gakki.leetcode;

/**
 * permutation 全排列
 * @author wangxiaobin
 */
public class Permutation {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        perm(a,0,a.length-1);
    }

    private static void printArr(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
        System.out.println();
    }

    private static void perm(int[] a,int start,int end) {
        if (start == end) {
//            return a[start];
            printArr(a);
        }
        else{
            for (int i  = start; i <= end; i ++){
            /*
            1,2,3,4
            ====>
            1,[后面的元素做全排列]
            2,[后面的元素做全排列]
            3,[后面的元素做全排列]
            4,[后面的元素做全排列]
             */
                // 把第i个元素作为 固定头部，后面的元素做全排列
                swap(a,start,i);
                perm(a,start+1,end);
                // 交换回来
                swap(a,start,i);
            }
        }


    }

    private static void swap(int[] a, int i, int i1) {
        int tmp = a[i];
        a[i]= a[i1];
        a[i1] = tmp;
    }
}
