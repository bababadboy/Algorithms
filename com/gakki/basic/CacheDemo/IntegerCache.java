package com.gakki.basic.CacheDemo;

import edu.princeton.cs.algs4.In;

/**
 * @author wangxiaobin
 */
public class IntegerCache {
    public static void main(String[] args) {
        Integer a1 = -128;
        Integer a2 = -128;
        // IntegerCache缓存池的大小为[-128,128)
        System.out.println("-128 == -128? "+ (a1 == a2));  // ture

        Integer b1 = 128;
        Integer b2 = 128;
        System.out.println("128 == 128? "+(b1 == b2));   // false

        Integer c1 = 127;
        Integer c2 = 127;
        System.out.println("127 == 127? "+(c1 == c2));   // false

        Integer d1 = -127;
        Integer d2 = -127;
        System.out.println("-127 == -127? "+(d1 == d2));   // false

    }
}
