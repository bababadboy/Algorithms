package com.gakki.basic.syncThread;

/**
 * @author wangxiaobin
 */
public class Bank implements Runnable{
    private int  money;

    public Bank(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void withdraw(int m) {
        if (m <= 0) {
            throw new IllegalArgumentException();
        }
        if (money - m >= 0) {
            money -= m;
        }
    }

    public void save(int m) {
        if (m <= 0) {
            throw new IllegalArgumentException();
        }
        money += m;
    }

    private synchronized void operateSave(int n) {

        for (int i = 0; i < 3; i++) {
            save(n);
            System.out.println("Save $" + n + ", now money is: " + getMoney() + ", have a break.");
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // synchronized 修饰符可以让该线程 保证不被中断的情况下完成。
    private synchronized void operateWithdraw(int n){
        withdraw(n);
        System.out.println("Withdraw $"+n+", now money is: "+getMoney()+", have a break.");
        try{
            Thread.sleep(500);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public synchronized void run() {
        if (Thread.currentThread().getName().equals("SAVE")) {
            operateSave(100);
        }
        else if (Thread.currentThread().getName().equals("WITHDRAW")) {
            operateWithdraw(50);
        }
    }
}
