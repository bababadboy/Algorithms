package com.gakki.leetcode;

import java.util.Scanner;
import java.util.*;
/**
 *
 * @author wangxiaobin
 */
public class CharDistance {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            char ch = chars[0];
            // 获取str的长度
            int len = str.length();
            // 返回结果集
            int[] res = new int[len];
            // 存储多个ch的位置
            List<Integer> locOfCh = new ArrayList<>();
            for(int i = 0; i < len; i ++){
                if(str.charAt(i) == ch){
                    locOfCh.add(i);
                }
            }
            final int maxDis = 42949672;
            for(int i = 0; i < len; i ++){
                int dis = maxDis;
                for(int j:locOfCh){
                    if(Math.abs(i-j) < dis){
                        dis = Math.abs(i-j);
                    }
                }
                res[i] = dis;
            }
            // 输入res
            System.out.print("[");
            for (int i = 0; i < res.length-1; i++) {
                System.out.print(res[i] + ",");
            }

            System.out.print(res[res.length-1]+"]");
        }

}
