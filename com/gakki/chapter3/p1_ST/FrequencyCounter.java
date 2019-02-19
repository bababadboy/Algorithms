package com.gakki.chapter3.p1_ST;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 统计tale.txt(《双城记》)中单词长度大于等于args[0]的单词数量
 * @author wangxiaobin
 */
public class FrequencyCounter {
    public static void main(String[] args){
        SequentialSearchST<String,Integer> searchST = new SequentialSearchST<>();
        // 获取需要过滤的最小单词长度的值
        if (args.length < 2) {
            throw new IllegalArgumentException("Give a frequency");
        }
        // 获取需要过滤的最小长度
        int minLen = Integer.parseInt(args[0]);
        // 获取输入流
        try {
            // 获取文件路径
            Scanner sc = new Scanner(new File(args[1]));
            while(sc.hasNext()){
                // 读取文件的每一行
                String s = sc.next();
                // 把行分割成若干个单词
                String[] words = s.split(" ");
                // 把单词长度>=8的单词加入符号表searchST
                for (String word:words
                     ) {
//                    System.out.println(word);
                    if (word.length() < 8)
                        continue;
                    if (!searchST.contains(word)) {
                        searchST.put(word,1);
                    }
                    else{
                        searchST.put(word,searchST.get(word) + 1);
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


//         把长度的>= args[0] 的单词加入searchST,key->word,val->frequencyOfWord
//        while (!StdIn.isEmpty()) {
//            String word = StdIn.readString();
//            if (word.length() < 8)
//                continue;
//            if (!searchST.contains(word)) {
//                searchST.put(word,1);
//            }
//            else{
//                searchST.put(word,searchST.get(word) + 1);
//            }
//        }
        // 找到最大的frequencyOfWord存入的searchST的<maxFreWord,frequencyOfWord>中
        String maxFreqWord = " ";
        searchST.put(maxFreqWord,0);
        for (String word : searchST.keys()) {
            if (searchST.get(word) > searchST.get(maxFreqWord)) {   // 更新最大频次的单词
                maxFreqWord = word;
                searchST.put(maxFreqWord,searchST.get(word));
            }
        }
        System.out.println("在文件"+args[1]+"中，单词长度不小于8的频次最大的单词是："+maxFreqWord+"->"+searchST.get(maxFreqWord)+"次");
    }
}
