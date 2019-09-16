package com.gakki.leetcode.questions_easy.string;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 * @author wangxb XD
 * @date 2019-09-15
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String[] strs = new String[n];
        strs[0] = "1";
        for(int i = 1; i < strs.length; i ++){
            strs[i] = read(strs[i-1]);
        }
        return strs[n-1];
    }

    private String read(String s){
        StringBuilder res = new StringBuilder();
        char[] chs = s.toCharArray();
        int cnt = 1;    // 记录连续的重复的个数
        for(int i =0; i < chs.length; i ++){
            while(i < chs.length - 1 && chs[i] == chs[i + 1]){
                cnt ++;
                i ++;
            }
            res.append(cnt);
            res.append(chs[i]);
            cnt = 1;
        }
        return res.toString();
    }
}
