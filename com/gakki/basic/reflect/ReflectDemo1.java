package com.gakki.basic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 使用Class api实现反射机制
 * @author wangxiaobin
 */
public class ReflectDemo1 {
    public ReflectDemo1() {
        try {

            //获取整个类
            Class clazz = Class.forName("com.gakki.basic.reflect.Person");
            // 获取类所有属性
            Field[] fields = clazz.getDeclaredFields();
            // 定义变长字符串，存储信息
            StringBuilder sb = new StringBuilder();
            // public 定义
            sb.append(Modifier.toString(clazz.getModifiers()) + " class " + clazz.getSimpleName() +"{\n");

            // 类内部属性
            for(Field field: fields){
                sb.append("\t");
                sb.append(Modifier.toString(field.getModifiers())+"\t"); // 获得属性的修饰符，例如public，static等等
                sb.append(field.getType().getSimpleName()+"\t");    // 类型的名字
                sb.append(field.getName()+";\n");      // 属性名字
            }

            sb.append("}");
            System.out.println(sb);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ReflectDemo1();
    }
}
