package com.gakki.leetcode.problemset.algorithms.T_929;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-email-addresses/
 * @author wangxiaobin
 */
public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String e : emails) {
            // 用e中唯一的'@'分割，得含有两个字符串的数组
            String[] tokens = e.split("@");
            String localName  = tokens[0];

            // 对localName处理
            localName = filter(localName);

            // 重新合并
            String res = localName+"@"+tokens[1];
            emailSet.add(res);

        }

        return emailSet.size();
    }

    private String filter(String localName) {
        String s = localName;
        int plusIdx = s.indexOf('+');
        if (plusIdx > 0){
            s = s.substring(0,plusIdx);
        }

        s = s.replaceAll("\\.", "");
        return s;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] emails = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        System.out.println(s.numUniqueEmails(emails));
    }
}
