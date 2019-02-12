package com.gakki.chapter2;



/**
 * 基于堆(数组存储)的优先队列
 * @author wangxiaobin
 */
public class MaxPQ<Key extends Comparable<Key>>{
    // 第零个元素不使用
    private int N = 0;

    private Key[] pq;

    public MaxPQ() {
    }

    /**
     * SuppressWarnings注解可以消除强制类型转换的警告
     */
    @SuppressWarnings(value = "unchecked")
    public MaxPQ(int max) {
        pq = (Key[])new Comparable[max+1];
    }

    /**
     * 接受一个数组的构造函数
     */
    @SuppressWarnings(value = "unchecked")
    public MaxPQ(Key[] keys){
        pq = (Key[]) new Comparable[keys.length+1];
        for (Key item:
             keys) {
            pq[++ N] = item;
            swim(N);
        }
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int size(){
        return N;
    }

    /**
     * 返回队列的最大元素,不删除。
     * @return 最大元素
     */
    public Key max(){
        return pq[1];
    }

    /**
     * 返回队列的最大元素，并删除
     * @return 最大元素
     */
    public Key delMax() {
        Key max = pq[1];
        exch(N,1);
        // 避免孤儿对象
        pq[N --] = null;
        sink(1);
        return max;
    }

    public void insert(Key key) {
        pq[++ N] = key;
        swim(N);
    }

    /**
     * 打印输出
     */
    public void print(){
        for (int i = 1; i <= N; i++){
            System.out.print(pq[i]+"\t");
        }
        System.out.println();
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