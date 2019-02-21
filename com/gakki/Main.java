package com.gakki;

import com.gakki.chapter2.p4_prioQue.MaxPQ;

public class Main {

    public static void main(String[] args) {
        int size = 10;
        MaxPQ<Integer> maxPQ = new MaxPQ<>();
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
