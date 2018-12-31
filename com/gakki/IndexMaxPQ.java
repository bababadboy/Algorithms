package com.gakki;

/**
 * 关联索引的最大优先队列
 * @author wangxiaobin
 */
public class IndexMaxPQ<Key extends Comparable<Key>> {

    private int N;          // 实际长度
    private Key[] keys;     // 元素,index -> key
    private int[] pq;       // 索引,priority -> index
    private int[] qp;       // pq的逆序索引

    /**
     * 构造函数
     * @param max
     */
    public IndexMaxPQ(int max){
        if (max < 0) throw new IllegalArgumentException();

    }

    /**
     * @return 队列的大小
     */
    public int size(){
        return N;
    }

    /**
     *
     * @param k  待关联的索引
     * @param key 待插入的元素
     */
    public void insert(int k,Key key){

    }

    /**
     * 队列是否为空
     * @return true or false, which means empty or not empty
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 删除队列的最大值，并且返回其索引
     * @return 队列的最大值
     */
    public int delMax(){}

    /**
     * 返回队列最大值的索引
     */
    public int max(){

    }

    /**
     * 把索引为{@code k}的元素改为{@code key}
     */
    public void change(int k, Key key){}

    /**
     * 判断是否存在索引为{@code k}的元素
     */
    public boolean contains(int k){}

    /**
     * 删除索引{@code k}，及关联元素
     */
    public void delete(int k){}

    private void swim(){

    }
    private void sink(){

    }
    private boolean less(){
        return true;
    }

    private void exch(){

    }


}
