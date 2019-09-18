package com.gakki.leetcode.questions_easy.array;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @author wangxb XD
 * @date 2019-09-17
 */
public class PlusOne {

    /**
     * bug:超出Integer.MAX_VALUE限制
     */
    public int[] plusOne(int[] digits) {
        int num = 0;
        for (int i = digits.length-1,pow = 0; i >= 0; i --,pow++) {
            int n = (int)Math.pow(10,pow);
            int add = n*digits[i];
            num += add;
        }
        num = num + 1;
        int[] res = new int[lenOf(num)];
        int i = res.length - 1;
        while (num > 0){
            res[i] = num % 10;
            num /= 10;
            i --;
        }
        return res;
    }

    private int lenOf(int num) {
        int n = num;
        int len = 0;
        while (n > 0){
            n /= 10;
            len ++;
        }
        return len;
    }

    public int[] plusOne2(int[] digits) {
        int[] res = Arrays.copyOf(digits,digits.length);
        int i = res.length - 1;
        for (; i >= 0; i--) {
            int addone= res[i] + 1;
            if (addone >= 10){
                res[i] = 0;
            }else {
                res[i] = addone;
                break;
            }
        }
        // 进位
        if (i == -1){
            res = new int[res.length+1];
            res[0] = 1;
        }
        return res;
    }



    public static void main(String[] args) {
//        int[] a=  new PlusOne().plusOne2(new int[]{9,8,7,6,5,4,3,2,1,0});
//        for (int i : a) {
//            System.out.print(i+"\t");
//        }

        int[] b =  new PlusOne().plusOne2(new int[]{9,9,9,9});
        for (int i : b) {
            System.out.print(i+"\t");
        }
    }
}
