package com.gakki.nowcoder.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 原地单向链表翻转
 * @author wangxb XD
 * @date 2019-08-18
 */
public class ReverseLinkedList {

    public List<Integer> printListFromTailToHead(ListNode listNode) {

        List<Integer> list = new ArrayList<>();
        ListNode p = null;
        ListNode q = null;
        ListNode head = listNode;
        // 原地翻转链表
        while(head != null){
            p = head;
            head = head.next;
            p.next = q;
            q = p;
        }
        // 赋值
        while(p != null){
            list.add(p.val);
            p = p.next;
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
