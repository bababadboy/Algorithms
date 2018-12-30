package com.gakki;

import java.io.Serializable;


/**
 * 基于堆(数组存储)的优先队列
 * @author wangxiaobin
 */
public class MaxPQ<Key extends Comparable<Key>>{
    // 第零个元素不使用
    private int N = 0;

    private Key[] pq;

    /**
     * SuppressWarnings注解可以消除强制类型转换的警告
     */
    @SuppressWarnings(value = "unchecked")
    public MaxPQ(int max) {
        pq = (Key[])new Comparable[max+1];
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int size(){
        return N;
    }

    public Key delMax() {
        exch(N,1);
        // 避免孤儿对象
        pq[N --] = null;
        sink(1);
        return pq[1];
    }

    public void insert(Key key) {
        pq[++ N] = key;
        swim(N);

    }
    // 打印输出
    public void print(){
        for (int i = 1; i <= N; i++){
            System.out.print(pq[i]+"\t");
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = k * 2;  // 左节点
            if (j < N && less(j,j+1)) ++ j;   // 比较父子节点、左右节点
            if (less(k, j))
                exch(k,j);
            k  = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k,k/2);
            k = k / 2;
        }
    }

    private void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

}
