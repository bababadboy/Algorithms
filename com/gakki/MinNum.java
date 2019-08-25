package com.gakki;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：来自阿里电话面试(王晓斌)，哔哩哔哩笔试题（颜志成）
 * 描述：输入，一个int数组（没有重复），例如：[123,1]；又例如，[44,123,2233]
 * 要求：组合数组中的所有元素，返回最小值。例如：1123(1123<1231)；123223344
 * 思路: 首先给
 * @author wangxb XD
 * @date 2019-08-25
 */
public class MinNum {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int len = in.nextInt();

        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.next();
        }

        Arrays.sort(arr,(a,b)->{
            return a.concat(b).compareTo(b.concat(a));
        });

        StringBuilder sb = new StringBuilder();
        for(String s:arr){
            sb.append(s);
        }
        System.out.println(sb.toString());

    }

}