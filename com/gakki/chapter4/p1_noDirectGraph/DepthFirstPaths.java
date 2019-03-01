package com.gakki.chapter4.p1_noDirectGraph;

import com.gakki.chapter4.Graph;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * 图深度优先搜索路径
 * @author wangxiaobin
 */
public class DepthFirstPaths {
    private boolean[] marked;   // If the vertex is marked
    private int[] edgeTo;   // 记录路径的最后一个节点
    private final int s;
    /**
     * 路径构造函数，在G图中构建一条以s为开始的路径
     * @param G 图G
     * @param s 顶点s
     */
    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }
    public boolean hasPathTo(int s) {
        return marked[s];
    }

    /**
     * 以s作为起始节点（深度优先）遍历图G
     * @param G 图G
     * @param s 起始顶点s
     */
    private void dfs(Graph G, int s) {
        marked[s] = true;
        for(int w:G.adj(s)) {
            if (!marked[w])  // 如果没有被标记过
            {
                edgeTo[w] = s;  // 把s作为w的上一个顶点
                dfs(G,w);       // 继续冲w开始深度递归
            }
        }
    }

    /**
     * 寻找一条从顶点s,到顶点w的路径
     * @param w 终点w
     */
    public Iterable<Integer> path(int w){
        if (!hasPathTo(w))
        {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        // 从edgeTo中可以了解到w到s的路径
        for (int x = w; x != s; x= edgeTo[x]) {
            // 从终点w反向搜索路径，并压入栈中
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }
    public static void main(String[] args){
        // 创建一个6个节点,8条边的图
        Graph G = new Graph(6);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,5);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(2,4);
        G.addEdge(3,4);
        G.addEdge(3,5);
//        System.out.println(G.toString());

        // 在G中创建一条以{@start}为开始的路径
        int s = 0;
        DepthFirstPaths search = new DepthFirstPaths(G,s);
        // 遍历输出G中以start为开始的路径
        for (int v = 0; v < G.V(); v ++) {
            StdOut.print(s+" to "+v+":");
            if (search.hasPathTo(v)) {
                for (int w : search.path(v)) {
                    if (s == w)
                        StdOut.println(s);
                    else
                        StdOut.print(w+"-");
                }

            }
            StdOut.println();
        }
    }
}















