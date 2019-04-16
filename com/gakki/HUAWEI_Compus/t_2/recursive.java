package com.gakki.HUAWEI_Compus.t_2;

import java.util.*;

/**
 * @author wangxiaobin
 */
public class recursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = "";
        int times = 1;
        Stack<String> stack = new Stack<>();
        man(s,stack,0,times);

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    private static String man(String s,Stack res,int from,int times) {
//        int idx = from;
        if (from >= s.length() -1)
            return null;

        while (s.charAt(from) >= 'A' && s.charAt(from) <= 'z'){
            if (times == 1){
                String t = ""+s.charAt(from);
                res.push(t);
                from ++;
            }
            else{

                String strAfterTimes =timesString(s,from,times);
                // 返回指针的位置
                from = getIdx(s,from);
                res.push(strAfterTimes);
            }
        }
        // 如果遇到后面一半括号
        if (s.charAt(from) == ')' || s.charAt(from) == ']' || s.charAt(from) == '}')
            if (from < s.length() -1)
                from ++;

        if (s.charAt(from) >= '0' && s.charAt(from) <= '9'){
            String s1 = s.charAt(from) + "";
            times = Integer.parseInt(s1);
            int cut = getIdx(s,0);
            s = s.substring(0,cut+1) +"("+ man(s,res,from+2,times)+")";
        }
        return s;

    }

    private static int getIdx(String s, int from) {
        int to = from;
        while (s.charAt(to) != ')' && s.charAt(to) <= 'z' && s.charAt(to) >= 'A'){
            to ++;
        }
        return to;
    }

    private static String timesString(String s, int from, int times) {
        String res = "";
        int to = getIdx(s,from);
        for (int i = 0; i < times; i++) {
            res += s.substring(from,to);
        }
        return res;
    }


}
