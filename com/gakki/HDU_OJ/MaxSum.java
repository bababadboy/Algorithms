package com.gakki.HDU_OJ;


import java.util.*;
/**
 * pid=1003
 * @author wangxiaobin
 */
public class MaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        for (int n = 0;  n < caseNum; n ++) {

            int size = sc.nextInt();
            int maxSum = 0;
            int from = 0;
            int to = 0;
            // 存到数组
            int[] arr = new int[size];
            for (int m = 0; m < size; m++){
                arr[m] = sc.nextInt();
            }

            for (int len = 1; len <= arr.length; len ++) {
                for (int i = 0; i <= size - len; i++) {
                    int sum = getSum(arr,i,len);
                    if( sum > maxSum){
                        maxSum = sum;
                        from = i;
                        to = i + len -1;
                    }
                }
            }

            System.out.println("Case "+(n+1)+":");
            System.out.println(maxSum+" "+(from+1)+" "+(to+1));
        }
    }

    private static int getSum(int[] arr, int i, int len) {
        int sum = 0;
        for (int j = i; j < i + len; j++) {

            sum += arr[j];
        }
        return sum;
    }
}
