package com.gakki.nowcoder.pdd笔试.pdd2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author wangxb XD
 * @date 2019-09-25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] treeCnt = new int[m];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int li = sc.nextInt();
            int ri = sc.nextInt();
//            int oldSize = set.size();
            for (int j = li; j <= ri ; j++) {
                set.add(j);
            }
            int newSize = set.size();
            treeCnt[i] =  newSize;
        }

        for (int i = 0; i < treeCnt.length; i++) {
            System.out.println(treeCnt[i]);
        }



    }
}
