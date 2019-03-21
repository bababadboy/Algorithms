package com.gakki.leetcode.DP;

/**
 * T338 https://leetcode-cn.com/problems/counting-bits/
 * @author wangxiaobin
 */
public class CountBits {
    public static void main(String[] args) {
        int[] a = countBits(5);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+'\t');
        }

        int[] b = countBitsFast(5);
    }

    private static int[] countBitsFast(int num) {
        int[] store = new int[num+1]; // 0...n+1,重叠子问题优化，存储每个数字的转成2进制后1的个数
        
        for(int i = 1; i <= num; i ++){
            int n = i;
            if (n % 2 == 1)
                store[i] = store[i/2] + 1;
            else
                store[i] = store[i/2];

        }
        return store;
    }


    public static int[] countBits(int num) {
        int[] arr = new int[num+1]; // 0...n+1

        for(int i = 0; i <= num; i ++){
            int count = 0;
            int n = i;
            while (n > 0){
                if(n%2 == 1)
                    count ++;
                n = n / 2;
            }
            arr[i] = count;
        }
        return arr;
    }
}
