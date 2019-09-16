package com.gakki.leetcode.questions_easy.string;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z  。
 * @author wangxb XD
 * @date 2019-09-15
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // 最短长度
        int len = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() < len){
                len = strs[i].length();
            }
        }
        // 匹配
        StringBuilder res = new StringBuilder("");
        for(int i = 0; i < len; i ++){
            int j = 1;
            while(j < strs.length){
                if(strs[j].charAt(i) != strs[0].charAt(i)){
                    return res.toString();
                }
                j ++;
            }
            res.append(strs[0].charAt(i));

        }

        return res.toString();
    }

    public static void main(String[] args) {
        new LongestCommonPrefix().longestCommonPrefix(new String[]{"aca","cba"});
    }
}
