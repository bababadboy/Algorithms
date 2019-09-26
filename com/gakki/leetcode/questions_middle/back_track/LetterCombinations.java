package com.gakki.leetcode.questions_middle.back_track;

import java.util.*;

/**
 * @author wangxb XD
 * @date 2019-09-25
 */
public class LetterCombinations {

    HashMap<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        if ("".equals(digits)){
            return new ArrayList<>();
        }
        // 初始化map
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        char[] digitsArr = digits.toCharArray();
        List<String> res = new LinkedList<>();
        String[] strs = new String[digitsArr.length];

        for (int i = 0; i < digitsArr.length; i++) {
            strs[i] = map.get(digitsArr[i]);
        }

        dfs(res,strs,0,"");

        return res;

    }

    private void dfs(List<String> res, String[] strs, int i,String str) {

        if (i == strs.length){
            res.add(str);
            return;
        }
        for (int j = 0; j < strs[i].length(); j++) {
            str = str + strs[i].charAt(j);
            dfs(res,strs,i+1, str);
            str = str.substring(0,str.length()-1);  // 恢复
        }


    }

    public static void main(String[] args) {
        List<String> l = new LetterCombinations().letterCombinations("");
        for (String str : l) {
            System.out.println(str);
        }
    }

}
