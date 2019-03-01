package com.gakki.chapter4.p1_noDirectGraph;

import com.gakki.chapter4.Graph;
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
}
