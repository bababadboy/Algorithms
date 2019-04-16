package com.gakki.basic.reflect;


/**
 * 使用getClass
 * @author wangxiaobin
 */
public class ReflectDemo2{
    public ReflectDemo2(Person person) {
        Class clazz = person.getClass();
    }
}
