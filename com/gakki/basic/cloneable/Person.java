package com.gakki.basic.cloneable;

/**
 * @author wangxiaobin
 */
public class Person  implements Cloneable{
    private int id;
    private String name;
    private String sex;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
