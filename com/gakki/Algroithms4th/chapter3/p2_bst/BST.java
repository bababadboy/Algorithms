package com.gakki.Algroithms4th.chapter3.p2_bst;

/**
 * @author wangxiaobin
 */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;          // 二叉查找树的根节点

    private class Node{
        private Key key;        // 键
        private Value val;      // 值
        private int N;          // 以该节点为根的子树节点总数（包括根节点）
        private Node left,right;// 左右节点

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    /**
     * 无参数构造函数
     */
    public BST(){

    }

    /**
     * 返回根节点的值
     * @return {@code root}
     */
    private Value get(){
        return root.val;
    }


    /*接口定义*/

    public int size(){
        return root.N;
    }

    /**
     *  返回子树节点个数
     * @param x 指定节点
     * @return 子树个数
     */
    public int size(Node x){
        if (x == null)          // 避免空指针异常
            return 0;
        else return x.N;
    }

    public Value get(Node x,Key key){
        // 从{@code x}节点开始向下查找
        int cmp = key.compareTo(root.key);
        if (x == null)
            return null;
        if ( cmp > 0)
            return get(x.right,key);
        if (cmp < 0)
            return get(x.left,key);
        else
            return x.val;
    }

    public void put(Key key,Value val){
        // 查找key，若找到则更新，否则插入新节点
        put(root,key,val);
    }

    private Node put(Node x, Key key, Value val){
        // 从Node x 开始put
        // 如果存在key,在更新key所在节点的val
        // 否则新建一个叶子节点
        if (x == null) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            return put(x.left,key,val);
        }
        else if (cmp > 0){
            return put(x.right,key,val);
        }
        else{
            x.val = val;
        }
        // 更新子树的节点个数
        x.N = x.left.N + x.right.N + 1;
        return x;
    }

// todo
//    public Key max(){}  // ojbk了
//    public Key min(){}  // 同上
//    public Value floor(){// 向下取整 }    // ojbk了
//    public Value ceiling(){// 向上取整}  // 同上
//    public int rank(){}   // ojbk
//    public Value select(){}   // 同上 逆操作
//    public void delMax(){}    // ojbk
//    public void delMin(){}    // 同上
//    public void delete(Key k) {}  //
//    public void print() {// 遍历}
//    public Iterable<Key> keys(Key lo, Key hi){}
//    public Iterable<Key> keys(){
//        return keys(min,max);
//    }



}
