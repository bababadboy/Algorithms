package com.gakki;

/**
 * 关联索引的最大优先队列
 * @author wangxiaobin
 */
public class MyIndexMaxPQ<Key extends Comparable<Key>> {

    private int N;          // 实际长度
    private Key[] keys;     // 有优先级之分的元素,index -> key
    private int[] pq;       // 索引二叉堆,从1开始，priority -> index
    private int[] qp;       // pq的逆序索引

    /**
     * 构造函数
     * @param max 最大长度
     */
    @SuppressWarnings(value = "unchecked")
    public MyIndexMaxPQ(int max){
        if (max < 0) throw new IllegalArgumentException();
        N = 0;                                        // 初始化队列长度为0
        keys = (Key[]) new Comparable[max+1];         // keys[0]不用
        qp = new int[max+1];
        pq = new int[max+1];
        for (int i = 0; i <= max; i ++){
            qp[i] = -1;                                // 初始化时
        }
    }

    /**
     * @return 队列的大小
     */
    public int size(){
        return N;
    }

    /**
     * 队列添加元素
     * @param k  待关联的索引,k > 0
     * @param key 待插入的元素
     */
    public void insert(int k,Key key){
        if (contains(k)) throw new IllegalArgumentException("Index is already in the priority queue");
        N ++;
        pq[N] = k;
        qp[k] = N;
        keys[k] = key;
        swim(N);
    }

    /**
     * 队列是否为空
     * @return {@code true} or {@code false}, which means empty or not empty
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 删除队列的最大值，并且返回其索引
     * @return 队列的最大值
     */
    public int delMax(){
        int maxIndex = pq[1];
        exch(1,N);
        pq[N] = -1;
        qp[maxIndex] = -1;
        sink(1);
        keys[maxIndex] = null;
        N--;
        return maxIndex;
    }

    /**
     * 返回队列最大值的索引
     */
    public Key maxKey(){
        return keys[pq[1]];
    }

    /**
     * 把索引为{@code k}的元素改为{@code key}
     */
    public void change(int k, Key key){}

    /**
     * 判断是否存在索引为{@code k}的元素
     * @param  k an index
     * @return {@code true} if {@code k} is an index on this priority queue;
     * {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     */
    public boolean contains(int k){
        return qp[k] != -1;
    }

    /**
     * 删除索引{@code k}，及关联元素
     */
    public void delete(int k){

    }

    public void print(){
        for (int i :
                pq) {
            if (i == 0) continue;
            System.out.print(keys[i]+"\t");
        }
    }

    /** util **/
    private void swim(int k){
        while (k > 1 && less(k/2, k)) {
            exch(k,k/2);
            k = k / 2;
        }
    }

    private void sink(int k){
        while (2 * k <= N) {
            int j = k * 2;  // 左节点
            if (j < N && less(j,j+1)) ++ j;   // 比较父子节点、左右节点
            if (less(k, j))
                exch(k,j);
            k  = j;
        }
    }
    private boolean less(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j){
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        // 同时维护qp
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public static void main(String[] args){
        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };

        MyIndexMaxPQ<String> pq = new MyIndexMaxPQ<>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i+1, strings[i]);
        }

        pq.print();

    }
}
