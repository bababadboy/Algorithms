package com.gakki.leetcode.questions_easy.string;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author wangxb (O_o)??)
 * @date 2019-09-05
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(120));
    }


    public static int reverse(int x) {
        int a = Math.abs(x);
        if (a < 0) {
            return 0;    // -2^31的abs溢出
        }

        Queue<Integer> q = new LinkedList<>();
        while (a > 0){
            q.offer(a%10);
            a = a / 10;
        }
        int r = 0;
        for (int size = q.size(); size > 0; size --) {
            // q.poll *10 ^ size - 1
            int add = 1;
            for (int i = 1; i < size; i++){
                if (add > Integer.MAX_VALUE / 10){  //add溢出；
                    return 0;
                }
                add *= 10;
            }
            if (q.peek() > Integer.MAX_VALUE / add){    // q.peek()为分母会出现 分母为0的情况
                return 0;
            }
            add *= q.poll();

            if (r > Integer.MAX_VALUE - add){    //  r > Integer.MAX_VALUE - add,r+add溢出
                return 0;
            }
            r += add;
        }

        return x<0?-r:r;

    }
}
