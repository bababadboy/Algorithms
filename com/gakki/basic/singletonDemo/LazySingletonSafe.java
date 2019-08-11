package com.gakki.basic.singletonDemo;

/**
 * 懒汉模式 --线程安全
 * @author wangxb XD
 * @date 2019-08-06
 */
public class LazySingletonSafe {


    private static LazySingletonSafe LazySingletonSafe = null;

    // 添加获取对象锁，开销较大
    public static synchronized LazySingletonSafe getInstance(){
        if (LazySingletonSafe == null){
            System.out.println("执行LazySingleton构造函数！！！");
            LazySingletonSafe = new LazySingletonSafe();
        }
        return LazySingletonSafe;
    }

    private LazySingletonSafe(){
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread("T"+i){
                @Override
                public void run() {
                    LazySingletonSafe.getInstance();
                }
            }.start();
        }
    }
}
