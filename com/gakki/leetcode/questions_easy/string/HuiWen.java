package com.gakki.leetcode.questions_easy.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * @author wangxb XD
 * @date 2019-09-15
 */
public class HuiWen {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length / 2; i++) {
            if (chs[i] != chs[chs.length - i - 1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new HuiWen().isPalindrome("A man, a plan, a canal: Panama");
    }
}
