package com.gakki.nowcoder.pdd笔试.pdd3;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 不多于n的a与不多于m的b的所有组合
 * @author wangxb XD
 * @date 2019-09-25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //a
        int m = sc.nextInt();   //b
        int k = sc.nextInt();

        List<String> list = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {

        }

        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(list.size()-k));

    }
}
