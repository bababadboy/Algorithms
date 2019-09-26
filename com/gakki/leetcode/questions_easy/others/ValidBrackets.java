package com.gakki.leetcode.questions_easy.others;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * @author wangxb XD
 * @date 2019-09-19
 */
public class ValidBrackets {
    public boolean isValid(String s) {
        if ("".equals(s)){
            return true;
        }
        if (s.length() % 2 == 1){
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
//        stack.push(chars[0]);
        for (char aChar : chars) {
            if (stack.size() > 0 && pairs(stack.peek(),aChar)) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.size() == 0;
    }

    private boolean pairs(char a, char b){
        if (a == '[' && b == ']'){
            return true;
        }else if (a == '{' && b == '}'){
            return true;
        }else if (a == '(' && b == ')'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean s = new ValidBrackets().isValid("{[)(]}");
        System.out.println(s);
    }
}
