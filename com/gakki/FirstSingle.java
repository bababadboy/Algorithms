package com.gakki;

/**
 * @author wangxb (O_o)??)
 * @date 2019-07-14
 */
public class FirstSingle {
    private static FirstSingle ourInstance = new FirstSingle();

    public static FirstSingle getInstance() {
        // 只能通过First.getInstance获取实例（只存在唯一一个）
        return ourInstance;
    }

    private FirstSingle() {
        // 私有构造函数
        System.out.println("This is a private constructor!");
    }
}
