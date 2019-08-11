package com.gakki.basic.classLoad.classGenerics;

import edu.princeton.cs.algs4.In;

/**
 * Class 对象泛型的作用: 仅是为了提供编译期类型的检查从而避免将错误延续到运行时期。
 *  https://blog.csdn.net/javazejian/article/details/70768369
 * @author wangxb (O_o)??)
 * @date 2019-07-29
 */
public class ClassGenDemo {
    public static void main(String[] args) {
        // 不使用泛型
        Class intClazz = int.class;
        // 使用泛型
        Class<Integer> integerClass = Integer.class;

        // 可以任意赋值，编译不会报错
        intClazz = double.class;
        // 不能赋值，因为已经指定类型
//        integerClass = Double.class;

        // 编译无法通过
//        Class<Number> numberClass = int.class;

        // 编译通过
        Class<? extends Number>  numberClass = int.class;
    }
}
