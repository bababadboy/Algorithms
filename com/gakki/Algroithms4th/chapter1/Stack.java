package com.gakki.Algroithms4th.chapter1;

import java.util.Iterator;

/**
 * 链表实现栈
 * @author wangxiaobin
 */
public class Stack<T> implements Iterable<T>{
    class Node{
        T item;
        Node next;
        public Node(T item){
            this.item = item;
        }
    }

    private Node first;     // 指向栈顶的指针
    private int len;

    public Stack(){
        first = null;
        len = 0;
    }

    public boolean isEmpty(){
        return len == 0;
    }

    public void push(T item) {
        Node n = new Node(item);
        n.next = first;
        first = n;
        len ++;
    }

    public T pop(){
        if (len == 0){
            return null;
        }
        Node r = first;
        first = r.next;
        len --;
        return r.item;

    }

    public T top(){
        if (len == 0){
            return null;
        }
        return first.item;
    }

    public int size(){
        return len;
    }

    @Override
    public Iterator iterator() {
        return new ReverseIterator();
    }
    class ReverseIterator implements Iterator<T>{
        Node p = first;
        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public T next() {
            T item = p.item;
            p = p.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Wxb");
        stringStack.push("Wxb1");
        stringStack.push("Wxb2");
        for (String s:stringStack
             ) {
            System.out.print(s+"\t");
        }
//        System.out.println(stringStack.pop());
//        System.out.println(stringStack.top());
    }
}
