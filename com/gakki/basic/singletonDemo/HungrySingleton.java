package com.gakki.basic.singletonDemo;


/**
 * 饿汉模式单例模式(也是idea自动生成singleton的方式) --线程安全
 * @author wangxiaobin
 */
public class HungrySingleton {

    private static HungrySingleton ourInstance = new HungrySingleton();

    static {
        System.out.println("执行了HungrySington的构造函数!!!");
    }

    public static HungrySingleton getInstance() {

        return ourInstance;
    }

    private HungrySingleton() {
    }

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            new Thread("T"+i){
                @Override
                public void run() {
                    // 不可能出现 多次执行构造函数
                    HungrySingleton.getInstance();
                }
            }.start();
        }
    }
}
