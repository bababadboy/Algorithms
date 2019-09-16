package com.gakki.leetcode.questions_easy.math;


import java.util.*;

/**
 * 质数删选，暴力超时
 * @author wangxb XD
 * @date 2019-09-14
 */
public class PrimeNumber {

    /**
     * 暴力超时
     */
    public int countPrimes(int n) {

        if (n <= 1) {
            return 0;
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!isNotPrime(i)) {
                cnt++;
            }
        }
        return cnt;

    }


    private boolean isNotPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 厄拉多塞筛法
     * 比如说求20以内质数的个数,首先0,1不是质数.2是第一个质数,
     * 然后把20以内所有2的倍数划去.2后面紧跟的数即为下一个质数3,
     * 然后把3所有的倍数划去.3后面紧跟的数即为下一个质数5,再把5所有的倍数划去.以此类推.
     *
     * 依旧超时
     */
    public int countPrimes2(int n) {
        if (n <= 2){
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 2; i < n; i++) {
            list.add(i);
        }
        int next = 2;
        for (int elem = next; elem <= list.getLast(); elem = next) {
            int nextIdx  = list.indexOf(elem) + 1;
            if (nextIdx >= list.size()){
                break;
            }
            next = list.get(nextIdx);
            // 删除 质数i的倍数
            int j = elem * 2;
            while (j <= list.getLast()) {
                list.remove(Integer.valueOf(j));
                j += elem;
            }

        }

        return list.size();
    }


    public static void main(String[] args) {
        System.out.println(new PrimeNumber().countPrimes2(10));
    }
}