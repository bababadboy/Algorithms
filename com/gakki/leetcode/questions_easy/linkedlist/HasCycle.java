package com.gakki.leetcode.questions_easy.linkedlist;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * @author wangxb XD
 * @date 2019-09-15
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        Map<ListNode,Integer> map = new HashMap<>();
        int pos = 0;
        while (p != null){
            if (map.containsKey(p)){
                return true;
            }
            map.put(p,pos);
            p = p.next;
            pos ++;

        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while(true)
        {
            if(fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                break;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(1);
        head.next = sec;
        sec.next = head;
        System.out.println(new HasCycle().hasCycle(head));
    }
}
