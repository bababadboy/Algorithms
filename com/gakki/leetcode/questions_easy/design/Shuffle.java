package com.gakki.leetcode.questions_easy.design;

import edu.princeton.cs.algs4.In;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangxb XD
 * @date 2019-09-12
 */
public class Shuffle {
    private int[] init;
    private int[] shuffle;
    private List<List<Integer>> permutation = new ArrayList<>();
    private int count;  // 排列组合可能性种类
    private  int i;
    private  int len;
    public Shuffle(int[] nums) {
        len = nums.length;
        init = new int[len];
        init = Arrays.copyOf(nums,len);
        i = 0;
        initPerm();
        count = permutation.size();
    }

    private void initPerm() {
        shuffle = Arrays.copyOf(init,len);
        perm(shuffle,0,init.length-1);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return init;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = getShuffle(i);
        i = (i + 1) % count;
        return res;
    }

    private int[] getShuffle(int i) {
        int[] res = new int[len];
        List<Integer> list = permutation.get(i);
        for (int x = 0; x < list.size(); x++) {
            res[x] = list.get(x);
        }
        return res;
    }

    private void perm(int[] a, int start, int end) {
        if (start == end) {
//            return a[start];
            if (equal(init,a)){
                return;
            }
            List<Integer> list = new ArrayList<>();
            for (int item : a) {
                list.add(item);
            }
            permutation.add(list);
        }
        else{
            for (int i  = start; i <= end; i ++){
                // 把第i个元素作为 固定头部，后面的元素做全排列
                swap(a,start,i);
                perm(a,start+1,end);
                // 交换回来
                swap(a,start,i);
            }
        }
    }

    private boolean equal(int[] init, int[] a) {
        for (int i = 0; i < init.length; i++) {
            if (init[i] != a[i]){
                return false;
            }
        }
        return true;
    }


    private static void swap(int[] a, int i, int i1) {
        int tmp = a[i];
        a[i]= a[i1];
        a[i1] = tmp;
    }

    public static void main(String[] args) {
        new Shuffle(new int[]{-6,10,184}).shuffle();
    }
}
