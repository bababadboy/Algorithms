package com.gakki.basic.multiThreading.runnableDemo;


/**
 * 实现了Runnable的Cake
 * @author wangxiaobin
 */
public class Cake implements Runnable{
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    int size;

    public Cake(int size) {
        this.size = size;
    }

    private void eatCake(int m) {
        if (size - m >=  0) {
            size -= m;
        }
        else
        {
            size = 0;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void run() {
        int n = 3;
        while (true) {
            System.out.println(Thread.currentThread().getName()+" eat: "+n);
            eatCake(n);
            System.out.println("Cake remains "+getSize());
            try {
                Thread.sleep(300);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            if (size <= 0){
                System.out.println(Thread.currentThread().getName()+" died.");
                return;
            }
        }
    }
}
