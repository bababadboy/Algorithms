package com.gakki.basic.futureDemo;

import java.util.concurrent.*;

/**
 * @author wangxb (O_o)??)
 * @date 2019-07-18
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread t1 = new Thread();
        MyRun t1 = new MyRun();
        Run2 t2  = new Run2();

        FutureTask<String> f1 = new FutureTask<>(t1,"t1 is finished!");
        FutureTask<String> f2 = new FutureTask<>(t2,"t2 is finished!");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(f1);
        executorService.submit(f2);

        while (true){
            if (f1.isDone() && f2.isDone()){
                // 使用get方法
                System.out.println(f1.get());
                System.out.println(f2.get());
                executorService.shutdown();
                return;
            }
        }

    }
}
