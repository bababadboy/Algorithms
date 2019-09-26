package com.gakki.nowcoder.pdd笔试.pdd2_1;

import java.util.Scanner;

/**
 * @author wangxb XD
 * @date 2019-09-25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] trees = new int[n+1];
        int[] treeCnt = new int[m];
        int  cnt = 0;
        for (int i = 0; i < m; i++) {
            int li = sc.nextInt();
            int ri = sc.nextInt();
            for (int j = li; j <= ri ; j++) {
                if (trees[j] == 0){
                    cnt ++;
                }
                trees[j] = 1;
            }
            treeCnt[i] =  cnt;
        }

        for (int i = 0; i < treeCnt.length; i++) {
            System.out.println(treeCnt[i]);
        }


    }

}
