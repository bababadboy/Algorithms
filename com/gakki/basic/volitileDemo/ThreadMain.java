package com.gakki.basic.volitileDemo;

import java.util.concurrent.*;

/**
 * @author wangxb
 */
public class ThreadMain {
    public static void main(String[] args) throws Exception{
        VolitileThread vt = new VolitileThread();

        ExecutorService pool = new ThreadPoolExecutor(2, 4, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(10), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return vt;
            }
        });
        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        vt.flag = true;
        System.out.println("i的值："+vt.i);
    }
}
