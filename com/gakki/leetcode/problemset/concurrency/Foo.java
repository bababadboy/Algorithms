package com.gakki.leetcode.problemset.concurrency;

/**
 * @author wangxb (O_o)??)
 * @date 2019-09-07
 */
public class Foo {
    public Foo() {

    }
    public void one() { print("one"); }
    public void two() { print("two"); }
    public void three() { print("three"); }

    private void print(String s) {
        System.out.println(s);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
//        new Thread(new PrintOne()).start();
//        new Thread(new PrintTwo()).start();
//        new Thread(new PrintThree()).start();

        new Foo().first(new PrintOne());
        new Foo().second(new PrintTwo());
        new Foo().third(new PrintThree());
    }
}
