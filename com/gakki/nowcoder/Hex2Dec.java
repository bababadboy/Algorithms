package com.gakki.nowcoder;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 * @author wangxb (O_o)??)
 * @date 2019-08-11
 */
public class Hex2Dec {
    private static final Map<Character,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        // A->10...F->15
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);
        for (int i = 0; i <= 9; i++) {
            map.put((char)i,i);
        }

        Scanner in = new Scanner(System.in);
        // 最终的十进制数
        int dec=0;
        while (in.hasNext()){
            String s = in.next();
            if (!s.startsWith("0x")){
                System.out.println("输入有误!!!");
            }

            String subStr = s.substring(2); // 0x占两个字符

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < subStr.length(); i++) {
                stack.push(subStr.charAt(i));
            }

            int move = 0;
            while (!stack.isEmpty()){
                char ch = stack.pop();
                int n = map.get(ch);
                dec += n * Math.pow(16,move);
                move ++;
            }
            System.out.println(dec);
        }


    }
}
