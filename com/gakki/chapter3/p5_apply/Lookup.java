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
        //文件路径为：/Users/wangxiaobin/IdeaProjects/Algorithms/hosts.txt
        if (args.length < 3){
            throw new IllegalArgumentException();
        }
        In in = new In(args[0]);
        String sep = "\t";
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        TreeMap<String, Queue<String>> st = new TreeMap<>();    // 正向索引key->val(s)
        TreeMap<String, Queue<String>> ts = new TreeMap<>();    // 反向索引val->key(s)
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

            if (!st.containsKey(key)) {
                // st中不包含key
                st.put(key,new PriorityQueue<>());
            }
            if (!ts.containsKey(val)) {
                // ts中不包含val键
                ts.put(val,new PriorityQueue<>());
            }
            st.get(key).add(val);
            ts.get(val).add(key);
        }
         //读入需要查找的键，并输入对应的值
        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            if (st.containsKey(query))
            {
                Queue<String> q = st.get(query);//for debug
                for (String val:st.get(query)
                     ) {
                    System.out.println(" "+val);
                }
            }
            if (ts.containsKey(query)) {
                for (String key:ts.get(query)
                     ) {
                    System.out.println(" "+key);
                }
            }
            else if (!st.containsKey(query))
            {
                // ts和st中都没有query,注意这里的else if 和就近的if配对
                System.out.println("文件中没有"+query);
            }
        }

    }
}
