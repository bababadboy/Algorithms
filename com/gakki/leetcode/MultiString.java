package com.gakki.leetcode;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 字符串相乘:
 * 给定两个数字（0-9）字符串（长度不限）求它们的乘积。
 * 输入描述:
 * 第一行为第一个数字字符串
 *
 * 第二行为第二个数字字符串
 *
 * 输入
 * 123
 * 20
 * 输出
 * 2460
 * @author wangxiaobin
 */
public class MultiString {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger bigInteger1 = scanner.nextBigInteger();
        BigInteger bigInteger2 = scanner.nextBigInteger();
        System.out.println(bigInteger1.multiply(bigInteger2));
    }
}
