package com.gakki.leetcode.questions_middle.back_track;

import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 * @author wangxb XD
 * @date 2019-09-25
 */
public class GenerateParenthesis {
    /**
     *
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generate(res,"(",1,0,1,2*n);
        return res;
    }

    private void generate(List<String> res, String str, int leftCnt, int rightCnt, int depth,int maxDepth) {
        if (leftCnt > maxDepth/2 || rightCnt > maxDepth/2){
            return;
        }
        if (rightCnt > leftCnt){
            return;
        }
        if (depth == maxDepth){
            res.add(str);
        }
        generate(res,str+"(",leftCnt+1,rightCnt,depth+1,maxDepth);
        generate(res,str+")",leftCnt,rightCnt+1,depth+1,maxDepth);
    }

    public static void main(String[] args) {
        List<String> list = new GenerateParenthesis().generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }

    }
}
