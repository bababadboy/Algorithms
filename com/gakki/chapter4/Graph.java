package com.gakki.chapter4;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * 无向图的邻接表实现
 * @author wangxiaobin
 */
public class Graph {
    private int V;  // 顶点个数 Vertex
    private int E;  // 边个数  Edge
//    private List<List<Integer>> adj;  // 邻接表  Adjacent List
    private List<Integer>[] adj;  // 邻接表  Adjacent List

    /**
     * 构造节点数为V的图，边数为0
     * @param V 图的节点数
     */
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];    // 不能创建泛型数组
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    /**
     * 通过输入流构造图
     * @param in 输入流
     */
    public Graph(In in){
        this(in.readInt()); // 读取V，并调用Graph(int V)构造方法
        E = in.readInt();   // 读取E，边数
        for (int i = 0; i < E; i++) {
            int w = in.readInt(); //读取顶点W
            int v = in.readInt(); //读取顶点v
            addEdge(w,v);         // 添加以w,v为节点的边
        }
    }

    // 顶点数
    public int V(){
        return V;
    }
    // 边数
    public int E() {
        return E;
    }
    // 在顶点v和w之间添加一条边
    public void addEdge(int v, int w){
        adj[v].add(w);  // v的邻接表加上w
        adj[w].add(v);  // w的邻接表加上v
        E++;
    }
    // 遍历与顶点v相邻的顶点
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < adj.length; i++) {
            s.append(i);
            s.append(":");
            for (int w:adj[i]
                 ) {
                s.append(w);
                s.append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        
    }
}
