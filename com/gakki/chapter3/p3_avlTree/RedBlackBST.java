package com.gakki.chapter3.p3_avlTree;

/**
 * 红黑树
 * @author wangxiaobin
 */
public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private Node root;  // 根节点
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node {
        Key key;
        Value val;
        Node left,right;
        int N;      // 节点计数器
        private boolean color;  // 指向该节点的链接颜色

        Node(Key key, Value val,int N,boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    /**
     * 插入节点，如果存在相同的键，则更新；否则创建新节点。
     */
    public void put(Key k,Value v){
        root = put(root,k,v);     // 从root节点（根节点）开始插入
        root.color = BLACK;      // 根节点的颜色始终为黑色
    }
//    public Node delete(){} todo
    public int size(){
        return size(root);
    }
    private int size(Node h){
        if (h == null)
            return 0;
        return h.N;
    }

    private Node put(Node h,Key k,Value v){
        if (h == null) {
            // 当递归到空链接时
            return new Node(k,v,1,RED);
        }
        // 比较参数k和树中节点的key的大小
        int cmp = k.compareTo(h.key);
        if (cmp < 0){
            // 插入的更小
            h.left =  put(h.left,k,v);
        }
        else if (cmp > 0){
            // 插入的更大
            h.right =  put(h.right,k,v);
        }
        else{ // 若key相等，则更新val
            h.val = v;
        }
        // 平衡红黑树操作
        boolean a = isRED(h.right);
        boolean b = !isRED(h.left);
        if (isRED(h.right) && !isRED(h.left))           // 如果只有右子链接为红
            h = rotateLeft(h);
        else if (isRED(h.left) && isRED(h.left.left))   // 连续两个左子链接为红
            h =  rotateRight(h);
        else                                            // 左右子节点均为红
            flipColors(h);
        h.N = size(h.left) + size(h.right) +1;  // 更新节点计数器
        return h;
    }

    /**
     * 判断一个节点是否是红节点（指向它的链接是否是红链接）
     * @param h 待判断的节点
     * @return 红为true;黑为false
     */
    private boolean isRED(Node h){
        if (h == null){
            return false;   // 空链接为黑色，否则在{平衡红黑树操作}判断中会出错
        }
        return h.color == RED;
    }
    private Node rotateLeft(Node h){
        // 向左旋转
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        // 更新节点计数器 todo 此处略有不熟
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    private Node rotateRight(Node h){
        // 向右旋转,与向左相反
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        // 更新节点计数器 todo 此处略有不熟
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    private void flipColors(Node h){
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }
    public static void main(String[] args) {
        RedBlackBST<String ,Integer> bst = new RedBlackBST<>();
        bst.put("a",1);
        bst.put("b",2);
//        bst.put("d",3);
//        bst.put("b",4);

    }
}
