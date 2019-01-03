package com.gakki.chapter3;

/**
 * @author wangxiaobin
 */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;          // 根节点

    private class Node{
        private Key key;        // 键
        private Value val;      // 值
        private int N;          // 子树节点个数
        private Node left,right;// 左右节点
    }

    /*接口定义*/

    public int size(){}
    public int size(Node x){}
    public Value get(Key key){}
    private void put(Key key,Value val){}

    public Value max(){}
    public Value min(){}
    public Value floor(){}
    public Value ceiling(){}
    public int rank(){}
    public Value select(){}




}
