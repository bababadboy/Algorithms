package com.gakki;


import java.util.Stack;

/**
 * in:
 * (ab)2
 * out:
 * abab
 * in:a((bc)3d)2
 * out: abcbcbcdbcbcbcd
 * @author wangxb XD
 * @date 2019-08-10
 */
public class StrExt {
    public static void main(String[] args) {

        String ts = "aaaa((bc)3d)2";
        // 思路：利用两个栈
        System.out.println(strExt(ts));
    }

    private static String strExt(String s){

        StringBuilder res = new StringBuilder();

        Stack<String> nums = new Stack<>();
        Stack<String> chars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int type = typeOf(c);
            switch (type){
                case 1: chars.push(String.valueOf(c));break;
                case 2: nums.push(String.valueOf(c));break;
                default: return null;   // 输入字符串错误
            }

            if (!nums.empty()){
                // 获取倍数
                int x = Integer.valueOf(nums.pop());
                // 小括号中待被×的字符串
                StringBuilder sMuti = new StringBuilder();
                StringBuilder sAppend = new StringBuilder();
                while (!chars.isEmpty()){

                    String item = chars.pop();
                    if (")".equals(item)){
                        continue;
                    }
                    else if ("(".equals(item)){
                        // 在这里 运算字符串
                        for (int j = 0; j < x; j++) {
                            sMuti.append(sAppend.toString());
                        }
                        break;
                    }
                    sAppend.append(item);
                }
                // 把运算好的字符串再次放入栈中
                chars.push(sMuti.toString());
            }

        }
        // 遍历返回操作
        while (!chars.isEmpty()){
            res.append(chars.pop());
        }
        return reverse(res.toString());
    }

    /**
     * 字符串的反转
     */
    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len/2; i++) {
            char t = chars[i];
            chars[i] = chars[len-i-1];
            chars[len-i-1] = t;
        }

        return new String(chars);
    }

    /**
     * 判断字符的类型 [()A-Za-z]->1，[0-9]->2,其他->0
     * @param c 字符
     * @return 字符c的类型
     */
    private static int typeOf(char c) {
        if (c >= 'A' && c <= 'Z'){
            return 1;
        }else if (c >= 'a' && c <= 'z'){
            return 1;
        }else if (c == '(' || c == ')'){
            return 1;
        }else if (c >= '0' && c <= '9'){
            return 2;
        }else {
            return 0;
        }
    }

}
