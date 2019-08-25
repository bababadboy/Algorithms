package com.gakki.Algroithms4th.chapter3.p1_ST;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 顺序查找（基于无序链表）
 * @author wangxiaobin
 */
public class SequentialSearchST<Key extends Comparable<Key>,Value> implements Iterable {
    private Node head;  // 第一个节点
    private int length;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Value getVal() {
            return val;
        }
    }

    public SequentialSearchST() {
        head = null;
        length = 0;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node p = head;
            @Override
            public boolean hasNext() {
                return p.next ==null;
            }

            @Override
            public Object next() {
                p = p.next;
                return p;
            }
        };
    }

    public int size() {
        return length;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new PriorityQueue<>();   // 使用java.util中的优先队列
        Node p = head;
        while (p != null) {
            queue.add(p.key);
            p = p.next;
        }
        return queue;
    }

    public void print(){
        Node p = head;
        if (length == 0) {
            System.out.println("NULL");
        }
        while (p != null) {
            System.out.println(p.key+"->"+p.val);
            p = p.next;
        }
    }

    public void delete(Key k) {
        Node p = head;
        if (p == null) {
            // 空链表直接返回
            return;
        }
        if (length == 1) {
            // 只有一个节点
            if (p.key.equals(k)) {
                head = null;
                --length;
                return;
            }
        }
        // 删除处于链中的节点
        Node q = p.next;
        while (q != null) {
            if (q.key.equals(k)) {
                p.next = q.next;
                --length;
                return;
            }
            // p,q指针都向后移
            p = p.next;
            q = p.next;
        }
        // 删除处于链尾的节点(包含只剩一个节点的链表)
        // 此时p指向链尾
        if (p.key.equals(k)) {
            p.next = null;
            --length;
        }

    }

    public boolean contains(Key k) {
        boolean ifContains = false;
        Node p = head;
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
        Node p = head;
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

    public void put(Key k, Value v) {
        // 如果有相同的key，则更新val
        Node p = head;
        while (p != null) {
            if (k == p.key) {
                p.val = v;
                return;
            }
            p = p.next;
        }
        // 插入链表第一个位置（头插法）
        Node n = new Node();
        n.key = k;
        n.val = v;

        n.next = head;
        head = n;
        // 更新长度
        ++length;
    }

    private boolean less(Key k1, Key k2) {
        return k1.compareTo(k2) < 0;
    }

    public static void main(String[] args) {
        SequentialSearchST<String,Integer> st = new SequentialSearchST<>();
        st.put("a",1);
        st.print();
        st.put("b",2);
//        st.print();
        st.put("c",3);
//        st.print();
//
        st.put("b",4);
//        st.print();

//        st.delete("a");
//        st.print();

//        st.delete("a");
        st.print();
//
//        st.delete("b");
//        st.print();
        Iterator it = st.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

}
