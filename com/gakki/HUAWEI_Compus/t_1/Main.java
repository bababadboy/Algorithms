package com.gakki.HUAWEI_Compus.t_1;

import java.util.*;

/**
 * @author wangxiaobin
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 字符串数量
        int N = in.nextInt();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String s = in.next();
            int len = s.length();

            if (len < 8){
                s = addZero(s,8-len);
                list.add(s);
            }
            else if (len == 8){
                // 啥也不用做
            }
            else {
                // len > 8，分割成字符串数组,并且补0
                String[] token = cutString(s,len);
                for (String str:token) {
                    list.add(str);
                }
            }
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

        }
        for (String str : list) {
            System.out.print(str+" ");
        }

    }

    private static String[] cutString(String s, int len) {
        int size;
        if (len%8 == 0){
            // 整数倍
            size = len / 8;
        }else {
            size = len/8 + 1;
        }
        String[] res = new String[size];

        int cutNo = 0;
        int cutFrom = 0;
        while (cutNo < size){
            if (cutFrom+8 < s.length())
                res[cutNo] = s.substring(cutFrom,cutFrom+8);
            else {
                res[cutNo] = s.substring(cutFrom,s.length());
                res[cutNo] = addZero(res[cutNo],8 - res[cutNo].length());
            }
            cutNo ++;
            cutFrom += 8;
        }

        return res;
    }

    /**
     * @param s
     * @param i 需要补0的个数
     */private static String addZero(String s, int i) {
        StringBuilder sb = new StringBuilder(s);
        for (int j = 0; j < i; j++) {
            sb.append("0");
        }
        return sb.toString();
    }

}
