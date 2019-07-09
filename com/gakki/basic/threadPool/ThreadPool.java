package com.gakki.basic.threadPool;

import java.util.concurrent.*;

/**
 * https://blog.csdn.net/qq_25806863/article/details/71126867
 * @author wangxb
 */
public class ThreadPool {
    public static void main(String[] args) throws Exception{

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 睡眠两秒，打印日志
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" is running.");
            }
        };

        // Lambda Runnable
        Runnable myRun = ()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" is running!");
        };


        ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 10, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        System.out.println("---先开三个---");
        System.out.println("核心线程数：" + executor.getCorePoolSize());
        System.out.println("线程池大小：" + executor.getPoolSize());
        System.out.println("队列任务数：" + executor.getQueue().size());


        executor.execute(myRun);
        executor.execute(myRun);
        executor.execute(myRun);
        System.out.println("---再开三个---");
        System.out.println("核心线程数：" + executor.getCorePoolSize());
        System.out.println("线程池大小：" + executor.getPoolSize());
        System.out.println("队列任务数：" + executor.getQueue().size());



        Thread.sleep(8000);
        System.out.println("----8秒之后----");
        System.out.println("核心线程数：" + executor.getCorePoolSize());
        System.out.println("线程池大小：" + executor.getPoolSize());
        System.out.println("队列任务数：" + executor.getQueue().size());
        executor.shutdown();
    }
}
