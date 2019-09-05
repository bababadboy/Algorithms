package com.gakki.shuiyou_exam;

/**
 * @author wangxiaobin
 */
public class TranslateMoney {
    public static void main(String[] args) {
        // 之前怎么把int 转成String...哭了
        String s = "";
        s += 555;
        System.out.println(s);
        // 今后这么干
        int i = 233;
        System.out.println(String.valueOf(i));
    }

    public static String translateMoney(double d){
        String stringMoney = String.valueOf(d);
        return stringMoney;

    }
}
