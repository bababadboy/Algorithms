package com.gakki.nowcoder.pdd笔试.pdd1;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i]*arr[m*2-i-1];
        }
        System.out.println(sum);

        int sum2 = 0;
        List<Integer[]> list = new LinkedList<>();
        allposib(list,0,1,m*2);

    }

    private static void allposib(List<Integer[]> list,int n, int m,int size) {
        if (n > size/2 || m > size -1){
            return;
        }
        if (n >= m){
            return;
        }

        list.add(new Integer[]{n,m});
        System.out.println(n+","+m);
        allposib(list,n,m+1,size);
        allposib(list,n+1,m,size);
    }
}
