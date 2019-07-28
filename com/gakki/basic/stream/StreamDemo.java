package com.gakki.basic.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java8 新特性:Stream()
 * @author wangxiaobin
 */
public class StreamDemo {
    public static void main(String[] args) {

        /* 1. 把英文单词母变成大写 */
        String[] computersBrandSmallLetter = {"dell","lenovo","apple","samsung","hp","hasee"};


        // Before java8
        List<String> computersBrand= new ArrayList<>();

        for (String s : computersBrandSmallLetter) {
            computersBrand.add(s.toUpperCase());
        }
        System.out.println(computersBrand);

        // After java8
        /* 1. map */
        // a. Use stream().map()
        computersBrand = computersBrand.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(computersBrand);

        // b. use parallerStream().map()
        computersBrand = computersBrand.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(computersBrand);

        /* 2. filter */
        List<String> flist = computersBrand.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println(flist);

        /* 3. sorted */
        List<String> slist = computersBrand.parallelStream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(slist);

        /*reduce */
//        List<String> rlist = computersBrand.
    }
}
