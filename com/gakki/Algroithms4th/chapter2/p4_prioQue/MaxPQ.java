package com.gakki.Algroithms4th.chapter2.p4_prioQue;


/**
 * 基于堆(数组存储)的优先队列
 * @author wangxiaobin
 */
public class MaxPQ<Key extends Comparable<Key>> {
    // 第零个元素不使用
    private int N = 0;
    private int max = 1;
    private Key[] pq;

    public MaxPQ() {
        pq = (Key[])new Comparable[max+1];
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
        Key maxKey = pq[1];
        exch(N,1);
        // 避免孤儿对象
        pq[N --] = null;
        sink(1);

        /*修改数组大小*/
        if (N <= max/4) {
            resize(max/2);
        }
        return maxKey;
    }

    public void insert(Key key) {
        if (N+1 > max/2) {
            resize(2*max);
        }
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

    public void treePrint() {
        String tab = "\t";  // 间隔
        int level = (int)(Math.log(N)/Math.log(2))+1;      // 层数log2(N)=log(N)/log(2)
//        System.out.print("层数是："+Math.log(N)/Math.log(2));
        int[] pre = new int[level];        // 每层第一个元素前空的间隔数，pre[0]->第一层第一个元素前的间隔数
        // 对pre进行赋值
        for (int i = level-1; i >= 0; i --) {
            for (int j = 1; j <= level; j ++) {
                pre[i] = 2 * (j - 1);
            }
        }

        for (int i = 1; i <= N; i ++) {
        }
    }
    /**
     * 把旧的qp移动到大小为 s 的新数组
     * @param s 重新设定的大小
     * @return 新的Key数组
     */
    @SuppressWarnings(value = "unchecked")
    private void resize(int s) {
        Key[] temp = (Key[])new Comparable[s+1];
        for (int i = 0; i <= N; ++i) {
            temp[i] = pq[i];
        }
        pq = temp;
        max = s;
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
