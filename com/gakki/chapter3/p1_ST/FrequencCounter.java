package com.gakki.chapter3.p1_ST;

import edu.princeton.cs.algs4.StdIn;

/**
 * 统计tale.txt(《双城记》)中单词长度大于等于8的单词数量
 * @author wangxiaobin
 */
public class FrequencCounter {
    static void main(String[] args){
        SequentialSearchST<String,Integer> searchST = new SequentialSearchST<>();
        int minLen = Integer.parseInt(args[0]);

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < 8)
                continue;
            if (!searchST.contains(word)) {
                searchST.put(word,1);
            }
            else{
                searchST.put(word,searchST.get(word) + 1);
            }
        }

        String maxFreqWord = "";
        int max = 1;
        for (String word : searchST.)//todo

    }
}
