package com.gakki.basic.syncThread;

/**
 * 线程同步
 * @author wangxiaobin
 */
public class SyncDemo {
    public static void main(String[] args) {
        Bank bank = new Bank(200);
        Thread save = new Thread(bank);
        save.setName("SAVE");
        Thread withdraw = new Thread(bank);
        withdraw.setName("WITHDRAW");

        save.start();
        withdraw.start();
    }
}
