package com.gakki.chapter3.p1_ST;

/**
 * @author wangxiaobin
 */
public class SequentialSearchST<Key extends Comparable<Key>,Value> {
    private Node head;
    private int length;
    private class Node{
        Key key;
        Value val;
        Node next;
    }

    public SequentialSearchST() {
        head = new Node();
        head.next = null;
        length = 0;
    }

    public Iterable<Key> keys() {
        // todo
    }

    public boolean contains(Key k) {
        boolean ifContains = false;
        Node p = head.next;
        while (p != null) {
            if (p.key.compareTo(k) == 0) {
                ifContains = true;
                break;
            }
            p = p.next;
        }
        return ifContains;
    }

    public Value get(Key k) {
        Node p = head.next;
        Value val = null;   // 返回的值
        while (p != null) {
            if (p.key.compareTo(k) == 0) {
                val = p.val;
                break;
            }
            p = p.next;
        }
        return val;
    }

    public void put(Key k, Value v){

        // 找到待插入的位置
        Node p = head;
        while (p.next != null && less(p.next.key,k)) {
            p = p.next;
        }
        // 插入
        Node n = new Node();
        n.key = k;
        n.val = v;
        if (p.next != null) {
            n.next = p.next;
            p.next = n;
        }
        else {
            // 如果是第一个元素或者是最后一个元素
            p.next = p;
            p.next = null;
        }
        // 更新长度
        ++ length;
    }
    private boolean less(Key k1,Key k2) {
        return k1.compareTo(k2) < 0;
    }

}
