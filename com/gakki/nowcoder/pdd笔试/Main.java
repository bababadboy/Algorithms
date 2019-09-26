package com.gakki.nowcoder.pdd笔试;

import java.util.*;

/**
 * @author wangxb XD
 * @date 2019-09-25
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        String phoneNo  = sc.next();
        char[] phoneNoArray  = phoneNo.toCharArray();

//        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        int[] storeCount = new int[10];
        // 统计每个数字出现的个数
        for (int i = 0; i < phoneNoArray.length; i++) {
            int idx = Character.getNumericValue(phoneNoArray[i]);
            storeCount[idx] ++;
        }
        // 找到出现次数最多的数字
        int maxCnt = storeCount[0];
        List<Integer> mostFreqNos = new LinkedList<>();  // 存储出现最多次数的数字们
        mostFreqNos.add(0);
        for (int i = 1; i < storeCount.length; i++) {
            if (storeCount[i] == maxCnt){
                mostFreqNos.add(i);
            }
            if (storeCount[i] > maxCnt){
                mostFreqNos = new LinkedList<>();
                mostFreqNos.add(i);
                maxCnt = storeCount[i];
            }
        }
        // 找到 和 出现次数最多的数字 的差的绝对值 最小的diff个数
        int diff = k - maxCnt;
        int min = 0;
        for (Integer no : mostFreqNos) {
            int cha = 1;    // 与 no 的差
            int d = diff;
            int minMoney = 0;
            while (d > 0){
                if (no - cha >= 0){
                    for (int i = storeCount[no-cha]; i >0 && d > 0; i--) {
                        minMoney += cha;
                        d--;
                    }
                }
                if (no + cha < 10 && d > 0){
                    for (int i = storeCount[no+cha]; i >0 && d > 0; i--) {
                        minMoney += cha;
                        d--;
                    }
                }
                cha ++;
            }
            if (minMoney < min){
                min = minMoney;
            }
        }

        System.out.println(min);

    }
}
