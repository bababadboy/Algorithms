package com.gakki.chapter3.p3_avlTree;

/**
 * 左倾红黑树（LEFT-LEANING RED-BLACK BST，2-3树的代码实现）
 * @author wangxiaobin
 */
public class LeftLeaningRedBlackBST<Key extends Comparable<Key>,Value> {
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
     * 查找
     * @param k 查找的键
     * @return 返回{@Key}k对应的值
     */
    public Value get(Key k) {
        // 代码和BST的查找一模一样,使用非递归实现
        Node x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            }
            else if (cmp > 0) {
                x = x.right;
            }
            else {
                return x.val;
            }
        }
        return null;
    }
    public Value getMax() {
        if (root == null) {
            // 空树
            return null;
        }
        Node x = root;
        while (x.right != null) {
            x = x.right;
        }
        return x.val;
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
        if (isRED(h.left) && isRED(h.left.left))   // 连续两个左子链接为红
            h =  rotateRight(h);
        if (isRED(h.left) && isRED(h.right))                                           // 左右子节点均为红
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


    public void delete(Key k) {

    }

    /**
     * 删除树中的最大键
     */
    public void deleteMax() {
        // 最大值一定是在树的右子树的最底部
        // 返回根节点
        root = deleteMax(root);
        if (root != null) {
            root.color = BLACK;
        }

    }
    private Node deleteMax(Node h) {
        if (isRED(h.left)) {
            // 把左倾三节点改成右倾三节点(改了之后对应的2-3树是一样的)，为什么要改呢？//todo 解释此处修改的原因
            h = rotateRight(h);
        }
        if (h.right == null) {
            // →_→最右最底层的节点
            return null;
        }
        // borrow from sibling if necessary
        if (!isRED(h.right) && !isRED(h.right.left))
        {
            // 如果该节点是2节点，需要从兄弟节点借
            h = moveRedRight(h);
        }
        // move down one level
        // http://www.cs.princeton.edu/~rs/talks/LLRB/RedBlack.pdf中写的是
        // h.left = deleteMax(h.left);
        // todo 是不是权威错了
        h.right = deleteMax(h.right);
        return fixUp(h);
    }

    /**
     * 把兄弟节点（非2-节点，即h.right）的最大节点转移到h，h转移到 h.right。
     * @param h 父节点
     * @return h
     */
    private Node moveRedRight(Node h) {
        colorFlip(h);// 合并父节点和左右子节点为一个四节点
        if (isRED(h.left.left)) {
            // 如果h.left(即兄弟节点)不是2-节点
            h  = rotateRight(h);
            colorFlip(h);
        }
        // else否则直接合并、返回h
        return h;
    }
    // 删除操作的修改颜色，和插入操作相反
    private void colorFlip(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    private Node fixUp(Node h) {
        // 自底向上修复左倾红黑树
        if (isRED(h.right)) {
            // 三节点右倾（红链接在右边）
            h = rotateLeft(h);
        }
        if (isRED(h.left) && isRED(h.left.left)) {
            // 出现四节点
            rotateRight(h);
        }
        if (isRED(h.left) && isRED(h.right)) {
            // 左右子节点均为红链接（四节点），则转为两个2-节点一个父节点
            flipColors(h);
        }
        return h;
    }

    public static void main(String[] args) {
        LeftLeaningRedBlackBST<String ,Integer> bst = new LeftLeaningRedBlackBST<>();
        bst.put("M",1);
        bst.put("F",2);
        bst.put("BaseA",3);
        bst.put("S",4);

        System.out.println(bst.getMax());
        bst.deleteMax();
        System.out.println(bst.getMax());

    }
}
