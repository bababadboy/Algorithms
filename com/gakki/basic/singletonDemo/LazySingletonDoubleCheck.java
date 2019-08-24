package com.gakki.basic.singletonDemo;

/**
 * 懒汉模式-双重检验，相比LazySingletonSafe效率更高
 * @author wangxb (O_o)??)
 * @date 2019-08-23
 */
public class LazySingletonDoubleCheck {

    private static LazySingletonDoubleCheck instance = null;

    public static LazySingletonDoubleCheck getInstance(){

        if (instance == null){
            synchronized (LazySingletonDoubleCheck.class){
                if (instance == null){
                    System.out.println("执行LazySingletonDoubleCheck构造方法!!!");
                    instance = new LazySingletonDoubleCheck();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            // 使用多个线程访问，会出现执行多次构造函数的方法！！
            new Thread("T"+i){
                @Override
                public void run() {
                    LazySingletonDoubleCheck.getInstance();
                }
            }.start();
        }

        System.out.println(System.currentTimeMillis()-start);
    }

}
