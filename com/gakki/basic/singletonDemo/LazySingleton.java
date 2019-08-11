package com.gakki.basic.singletonDemo;

/**
 * 懒汉单例--非线程安全，不可用
 * @author wangxb (O_o)??)
 * @date 2019-08-06
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    public static LazySingleton getInstance(){
        if (lazySingleton == null){
            System.out.println("执行了LazySingleton的构造方法!!!");
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    private LazySingleton(){
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 使用多个线程访问，会出现执行多次构造函数的方法！！
            new Thread("T"+i){
                @Override
                public void run() {
                    LazySingleton.getInstance();
                }
            }.start();
        }
    }
}
