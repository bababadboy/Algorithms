package com.gakki.basic.multiThreading.joinDemo;



/**
 * 使用join方法当前线程排到后面
 * @author wangxiaobin
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("You have to finish your homework first!!");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t.start();

        // 只有当 t 线程运行完了之后才能执行 main 线程
        // 参数500 表示只等 500ms
        t.join(500);
        System.out.println("You can play games now!!!");

    }
}
