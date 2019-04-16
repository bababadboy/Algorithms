package com.gakki.basic.ArraysUtil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * java.util.Arrays 工具简单使用
 * @author wangxiaobin
 */
public class Main {
    public static void main(String[] args) {
        final int N =20;
        int[] arr = new int[N];

        Arrays.fill(arr,233);
        System.out.println(Arrays.toString(arr));

        List<Integer> list = Arrays.asList(233,455);
        Object[] objects = list.toArray();

        System.out.println("键233的位置:"+Arrays.binarySearch(arr,233));

        int[] b = Arrays.copyOfRange(arr,5,10);
        System.out.println("b："+Arrays.toString(b));

        int[] c = Arrays.copyOf(arr,arr.length);
        System.out.println("arr == c ?"+Arrays.equals(arr,c));


    }
}
