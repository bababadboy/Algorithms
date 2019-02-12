package com.gakki;

import com.gakki.chapter2.MaxPQ;

public class Main {

    public static void main(String[] args) {
        /* 给定大小构造函数 */
        int size = 10;
        MaxPQ<Integer> maxPQ = new MaxPQ<>(size);
        for (int i = 0; i < size; i++) {
            maxPQ.insert(i);
        }
        maxPQ.print();

        for (int i = 0; i < size; i++) {
            System.out.print(maxPQ.delMax() + "\t");
        }

        /* 传入数组的构造函数 */
        String[] strings = new String[]{"AI", "Lebron", "WANG", "JIM", "Stephen", "Rose"};
        MaxPQ<String> maxPQ1 = new MaxPQ<>(strings);
        maxPQ1.print();
    }
}
