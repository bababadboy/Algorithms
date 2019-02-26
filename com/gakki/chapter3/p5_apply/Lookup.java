package com.gakki.chapter3.p5_apply;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 查找ip.csv中ip对应的域名（有多个要列出多个）
 * @author wangxiaobin
 */
public class Lookup {
    public static void main(String[] args) {
        /* ~ java Lookup ip.csv 0 1
         运行Lookup 输入文件为ip.csv，键为第0列，值为第1列
        */
        //文件路径为：/Users/wangxiaobin/IdeaProjects/Algorithms/hosts.txt
        if (args.length < 3){
            throw new IllegalArgumentException();
        }
        In in = new In(args[0]);
        String sep = "\t";
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        TreeMap<String, Queue<String>> st = new TreeMap<>();
        // 循环读取，并建立符号表
        while (in.hasNextLine()) {
            String line = in.readLine();
            if (line.startsWith("#")){
                // 跳过以"#"开头的注释行
                continue;
            }
            if (line.isEmpty()){
                // 去除空行
                continue;
            }
            String[] token = line.split(sep);
            String key = token[keyField];
            String val = token[valField];

            if (st.containsKey(key)) {
                // 如果符号表中包含了key，则在key对应的valQueue中再加一个val
                st.get(key).add(val);
            }
            else {
                // 符号表中不包含key
                Queue<String> valQueue = new PriorityQueue<>();
                valQueue.add(val);
                st.put(key,valQueue);
            }
        }
         //读入需要查找的键，并输入对应的值
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.containsKey(query))
            {
                for (String val:st.get(query)
                     ) {
                    System.out.println(st.get(query));
                }
            }
            else
            {
                System.out.println("文件中没有以"+query+"的键");
            }
        }

    }
}
