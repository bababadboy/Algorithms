package com.gakki.leetcode;

/**
 * 汉诺塔递归实现
 * @author wangxiaobin
 */
public class Hanoi {
    public static void main(String[] args) {
        hanoi(3,'A','B','C');
    }

    /**
     * n个盘子的hanoi从A移动到C
     */
    public static void hanoi(int n, char A,char B,char C){
        // n==1,出口
        if (n == 1){
            System.out.println(A+" -> "+C);
        }
        else {
            hanoi(n-1,A,C,B);
            System.out.println(A+" -> " + C);
            hanoi(n-1,B,A,C);
        }
    }
}
