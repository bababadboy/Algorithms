package com.gakki.chapter4.p1_noDirectGraph;

import com.gakki.chapter4.Graph;

/**
 * 深度优先遍历
 * @author wangxiaobin
 */
public class DepthFirstSearch {

    private int count;
    private boolean[] marked;
    public void DepthFirstSearch(Graph G, int v) {
        marked = new boolean[G.V()];    // 每个节点对应一个标注,表明是否被访问过
        dfs(G,v);
    }
    private void dfs(Graph G,int v) {
        marked[v] = true;
        count ++;
        for (int w:G.adj(v)     // 从v的相邻节点作为入口
             ) {
            if (!marked[v]) {
                System.out.println(v);
                dfs(G,w);
            }
        }
    }
    private boolean isMarked(int v) {
        return marked[v];
    }
    private int getCount(){
        return count;
    }

}
