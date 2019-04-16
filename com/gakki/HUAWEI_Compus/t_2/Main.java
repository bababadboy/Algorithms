package com.gakki.HUAWEI_Compus.t_2;

import java.util.*;

/**
 * @author wangxiaobin
 */
public class Main {
    // 先考虑一层嵌套
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        Stack<Character> kuohaos = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9'){
                // 如果是数字，则 c * 括号里的字符串

                // 取出括号里的字符
                String inkuoHao = "";
                int from = i + 2;   // 需要翻倍的字符串的头
                // todo 多层嵌套括号
                while (chars[from] != ')'){
                    inkuoHao += chars[from]; // 后两位
                    from++;
                }

                String getOut = timesString(c,inkuoHao);
                stack.push(getOut);

                if (from == chars.length -1)
                    break;

                i = from + 1;
            }
            else {
                String str = c+"";
                stack.push(str);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    private static String timesString(char c, String inkuoHao) {
        String str = ""+c;
        int n = Integer.parseInt(str);
        StringBuilder sb = new StringBuilder(inkuoHao);
        for (int i = 0; i < n-1; i++) {
            sb.append(inkuoHao);
        }
        return sb.toString();
    }
}
