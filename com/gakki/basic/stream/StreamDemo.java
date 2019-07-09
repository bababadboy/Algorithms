package com.gakki.basic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wangxiaobin
 */
public class StreamDemo {
    public static void main(String[] args) {
        // stream 使用
        String[] strs = {"Dell","Lenovo","Apple","Samsung","Hp","Hasee"};
        List<String> list = Arrays.asList(strs);
        Stream<String> stream = list.stream();

        stream.sorted().forEach(System.out::println);
        System.out.println(String.valueOf(100.12));
    }
}
