package com.gakki.basic.Reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 这是啥东西？？？下次能不能写个注释？？？
 * @author wangxiaobin
 */
public class Main {
    public static void main(String[] args) {
        String string = "string";
        SoftReference softReference = new SoftReference(string);
        WeakReference weakReference = new WeakReference(string);
//        PhantomReference phantomReference = new PhantomReference();
    }
}
