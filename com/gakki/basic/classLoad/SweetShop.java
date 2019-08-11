package com.gakki.basic.classLoad;

/**
 * jvm类加载时机测试
 * @author wangxb (O_o)??)
 * @date 2019-07-29
 */
class Cookie{
    static{
        System.out.println("Loading cookie...");
    }
}

class Candy{
    static{
        System.out.println("Loading Candy...");
    }
}

class Gum{
    // 我也不知道这是啥东西，能吃不？
    static {
        System.out.println("Loading Gum...");
    }
}

public class SweetShop {
    public static void main(String[] args) {

        System.out.println("Inside main:");

        try{// Class.forName会触发类的加载
            Class.forName("com.gakki.basic.classLoad.Cookie");
            System.out.println("After Class.forName(\"com.gakki.basic.classLoad.Cookie\")");
        }catch (ClassNotFoundException e){
            System.out.println("Cookie class not found!");
        }


        // 使用.class（字面常量）获取类对象不会触发类的加载
        Class<?> cookieClass = Cookie.class;
        try {
            Cookie c = (Cookie) cookieClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("After Cookie.class");

        // Cookie 类已经加载过一次，不会加载第二次
        new Cookie();
        System.out.println("After creating cookie.");

        new Candy();
        System.out.println("After creating candy.");

        new Gum();
        System.out.println("After creating gum.");

    }
}
