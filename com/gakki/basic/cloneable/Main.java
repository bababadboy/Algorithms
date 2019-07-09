package com.gakki.basic.cloneable;

/**
 * @author wangxiaobin
 */
public class Main {
    public static void main(String[] args){
        Person p1 = new Person();
        Person p2 = p1;
        try {
            // 使用clone方法 拷贝一个新对象
            Person pCloneable = (Person) p1.clone();
            System.out.println(p1 == p2);
            System.out.println(p1 == pCloneable);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
