package com.gakki.chapter4.p1_noDirectGraph;

import com.gakki.chapter4.Graph;
import edu.princeton.cs.algs4.StdOut;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 广度优先遍历
 * @author wangxiaobin
 */
public class BreadthFirstPaths {
    private final int s;  // 初始节点
    private int[] edgeTo;   // 保存上一个节点
    private boolean marked[];   // 标记数组，标记是否被访问过

    public BreadthFirstPaths(Graph G,int s) {
        this.s = s;
        marked = new boolean[G.V()];    // 标记数组

        // 根据给定的图G初始化edgeTo
        edgeTo = new int[G.V()];
        bfs(G,s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new PriorityQueue<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int w: G.adj(x)) {
                if (!marked[w]) {
                    edgeTo[w] = x;  // 把x作为w的前置节点
                    marked[w] = true;
                    queue.add(w);   // 把w加到队列
                }
            }
        }
    }

    /**
     * 根据edgeTo反向索引，找到起点s到终点w的路径
     * @param w 终点w
     * @return The path from s to w
     */
    public Iterable<Integer> pathTo(int w) {
        if (!marked[w]){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(w);
        for (int x = edgeTo[w]; x != s; x= edgeTo[x]) {
            stack.push(x);
        }
        return stack;
    }

    /**
     * 起点s到终点w是否有路径
     * @param w 终点
     * @return 有路径返回true;反之false
     */
    public boolean hasPathTo(int w){
        return marked[w];
    }

    public static void main(String[] args) {
        Graph G = new Graph(6);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,5);
        G.addEdge(1,2);
        G.addEdge(2,3);
        G.addEdge(2,4);
        G.addEdge(3,4);
        G.addEdge(3,5);

        int start = 5;
        BreadthFirstPaths search = new BreadthFirstPaths(G,start);

        // 打印所有和start相连的路径
        for (int v = 0; v < G.V(); v ++) {
            StdOut.print(start+" to "+v+":");
            if (search.hasPathTo(v)) {
                for (int w : search.pathTo(v)) {
                    if (start == w)
                        continue;
                    else
                        StdOut.print(w+" - ");
                }

            }
            StdOut.println(start);
        }
    }
}