package com.gakki.chapter3.p1_ST;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 统计tale.txt(《双城记》)中单词长度大于等于args[0]的单词数量
 * @author wangxiaobin
 */
public class FrequencyCounter {
    public static void main(String[] args){
        SequentialSearchST<String,Integer> searchST = new SequentialSearchST<>();
        // 获取需要过滤的最小单词长度的值
        if (args.length == 0) {
            throw new IllegalArgumentException("Give a frequency");
        }
        int minLen = Integer.parseInt(args[0]);

        // 把长度的>= args[0] 的单词加入searchST,key->word,val->frequencyOfWord
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
        // 找到最大的frequencyOfWord存入的searchST的<maxFreWord,frequencyOfWord>中
        String maxFreqWord = " ";
        searchST.put(maxFreqWord,0);
        for (String word : searchST.keys()) {
            if (searchST.get(word) > searchST.get(maxFreqWord)) {   // 更新最大频次的单词
                searchST.put(maxFreqWord,searchST.get(word));
            }
        }
        StdOut.println(maxFreqWord+": "+searchST.get(maxFreqWord));
    }
}
