package com.gakki.chapter4;

import edu.princeton.cs.algs4.In;

/**
 * @author wangxiaobin
 */
public class Graph {
    public Graph(int V){
    }
    public Graph(In in){}
    // 顶点数
    public int V(){}
    // 边数
    public int E() {}
    // 在顶点v和w之间天机一条边
    public void addEdge(int v, int w){}
    // 遍历与顶点v相邻的顶点
    public Iterable<Integer> adj(){}

    @Override
    public String toString() {
        return "Graph{}";
    }

    public static void main(String[] args) {

    }
}
