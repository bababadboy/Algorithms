package com.gakki.leetcode.problemset.concurrency;

/**
 * @author wangxb (O_o)??)
 * @date 2019-09-07
 */
public class PrintOne implements Runnable {

    @Override
    public void run() {
        System.out.println("one");
    }
}
