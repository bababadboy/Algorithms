package com.gakki.chapter3.p1_ST;

import com.gakki.chapter2.p4_prioQue.MaxPQ;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 顺序查找（基于无序链表）
 * @author wangxiaobin
 */
public class SequentialSearchST<Key extends Comparable<Key>,Value>{
    private Node head;  // 第一个节点
    private int length;
    private class Node{
        Key key;
        Value val;
        Node next;
    }

    public SequentialSearchST() {
        head = null;
        length = 0;
    }
    public int size(){
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

    public void put(Key k, Value v){
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
        ++ length;
    }
    private boolean less(Key k1,Key k2) {
        return k1.compareTo(k2) < 0;
    }

}
