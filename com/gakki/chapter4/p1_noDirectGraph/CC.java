package com.gakki.chapter4.p1_noDirectGraph;

import com.gakki.chapter4.Graph;

/**
 * Connected Component，dfs查找连同分量
 * @author wangxiaobin
 */
public class CC {
    private int[] id;   // 连同分量id,[0...cc.count()-1]
    private boolean[] marked;   // 是否被访问过
    /**
     * 构造函数CC：查找图G中的所有连同分量
     * @param G 需要寻找连同分量的图
     */
    public CC(Graph G){
        marked = new boolean[G.V()];    // 初始化都未被访问过，置为false
        id = new int[];
        for (int v = 0; v < G.V(); v ++){
            if (!marked[v]){    // 寻找未被标记过的节点作为起点
                dfs(G,v);
            }
        }
    }
    private void dfs(Graph G, int s) {
        id[s] = 0;
        marked[s] = true;
        for (int w : G.adj(s)) { // 遍历s节点的邻接节点
            if (!marked[w]) {
                dfs(G,w);
            }
        }
    }
    /**
     * 判断节点W和v是否连同
     * @param v 顶点
     * @param w 顶点
     * @return true为连同；反之不连通
     */
    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    /**
     * 得到图的连同分量数
     * @return 连同分量数
     */
    public int count(){
        return id.length;
    }

    /**
     * 获取w的连通分量标记
     * @param w 顶点
     * @return w的连同分量标记
     */
    public int id(int w){
        return id[w];
    }

    public static void main(String[] args) {

    }

}
