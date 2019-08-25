package com.gakki.Algroithms4th.chapter4.p1_noDirectGraph;

import com.gakki.Algroithms4th.chapter4.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 符号图
 * @author wangxiaobin
 */
public class SymbolGraph {
    private Graph G;
    private Map<String,Integer> map;
    private String[] keys;

    /**
     * 构造函数：用指定路径的文件和分隔符构造
     * @param filename 文件路径
     * @param delim 分隔符
     */
    public SymbolGraph(String filename, String delim){
        map = new HashMap<>();

        try{
            // 获取输入流文件
            Scanner sc = new Scanner(new File(filename));
            // 扫描文件内容
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // 获取顶点名放入token
                String[] tokens = line.split(delim);
                // 把顶点名不重复的放入map.key
                for (String token:tokens
                     ) {
                    if (!map.containsKey(token))
                    {
                        map.put(token,map.size());
                    }
                }
            }
            // 根据map.size初始化keys
            keys = new String[map.size()];
            for (String s:map.keySet()
                 ) {
                keys[map.get(s)]=s;
            }

            // 构造图
            G = new Graph(map.size());
            sc = new Scanner(new File(filename));
            while (sc.hasNextLine()){
                String line  = sc.nextLine();
                String[] tokens = line.split(delim);
                G.addEdge(map.get(tokens[0]),map.get(tokens[1]));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }

    /**
     * key在图中是否是一个顶点
     * @param key 键
     * @return true:存在；反之：不存在
     */
    public boolean contains(String key){
        return map.containsKey(key);
    }

    /**
     * 索引index的顶点名
     */
    public String key(int index){
        return keys[index];
    }

    /**
     * 顶点名对应的索引
     */
    public int index(String key){
        return map.get(key);
    }
    public static void main(String[] args) {
        /*
         符号图的测试用例
         */
        // 文件路径，和分割符
        String filename = "/Users/wangxiaobin/IdeaProjects/Algorithms/routes.txt";
        String sep = " ";
        // 构造符号图
        SymbolGraph sg = new SymbolGraph(filename,sep);

        // 打印输出符号图
        Graph G = sg.G;
        for (int i  = 0; i < G.V(); i ++) {
            System.out.print(sg.key(i)+": ");
            for (int w:G.adj(i)
                 ) {
                System.out.print(sg.key(w)+" ");
            }
            System.out.println();
        }
    }
}
