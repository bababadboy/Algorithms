package com.gakki.basic.abstractClass;

/**
 * 抽象父类,抽象类命名方法建议Base或者Abstract开头
 * @author wangxb (O_o)??)
 * @date 2019-08-02
 */
abstract public class BaseA {
    public void fun(){}

    // 只有抽象方法子类才必须重写
    abstract public void abstractFun();
}
