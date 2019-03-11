package com.gakki.basic.factoryLearning;

/**
 * 不是很懂其意义
 * @author wangxiaobin
 */
public class ShapeFactory {
    public static <T> T getClass(Class<? extends T> clazz){
        T obj = null;
        try
        {
            obj = (T) clazz.getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }

}
