package com.gakki;

import java.util.*;

/**
 * 随机产生若干个(a)随机数，要求随机数的和(s)为固定
 * 思路：把s想成长度为s的尺子,那就
 * @author wangxb (O_o)??)
 * @date 2019-09-06
 */
public class RandomSumFix {
    public static void main(String[] args) {
        
        int[] arr = random(20,5);
    }

    /**
     * 生成一个 长度为num的，求和后为 sum 的数组
     * @param sum 和
     * @param num 个数
     * @return 随机数组
     */
    private static int[] random(int sum, int num) {
        // 断点个数
        int cut = num - 1;
        Set<Integer> cutsStore = new TreeSet<>();
        // 随机生成4个断点，不能重复
        while (cutsStore.size() < cut){
            cutsStore.add((int)  (Math.random() * sum));
        }
        // 添加删左右两个端点
        cutsStore.add(0);
        cutsStore.add(sum);

        List<Integer> cutListStore = new LinkedList<>(cutsStore);
        int[] res = new int[num];
        // 求差
        for (int i = 0; i < cutsStore.size() - 1; i++) {
            res[i] = cutListStore.get(i+1) - cutListStore.get(i);
        }
        return res;
    }
}

