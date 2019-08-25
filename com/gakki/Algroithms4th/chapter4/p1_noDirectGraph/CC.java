package com.gakki.Algroithms4th.chapter4.p1_noDirectGraph;

import com.gakki.Algroithms4th.chapter4.Graph;
import java.util.LinkedList;
import java.util.List;

/**
 * Connected Component，dfs查找连同分量
 * @author wangxiaobin
 */
public class CC {
    private int[] id;   // 连通分量id,[0...count-1]中可能
    private boolean[] marked;   // 是否被访问过
    private int count;      // 连通分量数
    /**
     * 构造函数CC：查找图G中的所有连同分量
     * @param G 需要寻找连同分量的图
     */
    public CC(Graph G){
        marked = new boolean[G.V()];    // 初始化都未被访问过，置为false
        id = new int[G.V()];
        count = 0;
        for (int v = 0; v < G.V(); v ++){
            if (!marked[v]){    // 寻找未被标记过的节点作为起点
                dfs(G,v);
                count ++;
            }
        }
    }
    private void dfs(Graph G, int s) {
        id[s] = count;
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
        return count;
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
        Graph G = new Graph(13);
        G.addEdge(0,5);
        G.addEdge(4,3);
        G.addEdge(0,1);
        G.addEdge(9,12);
        G.addEdge(6,4);
        G.addEdge(5,4);
        G.addEdge(0,2);
        G.addEdge(11,12);
        G.addEdge(9,10);
        G.addEdge(6,0);
        G.addEdge(7,8);
        G.addEdge(9,11);
        G.addEdge(5,3);

        CC cc = new CC(G);
        int ccNum = cc.count(); // 连通分量数目，标记为:0...ccNum-1

        /*  eg:[0,0,0,0,1,1,2,2,4,3,3,2,2]
            第i个连通分量:components[i]
         */
        List<Integer>[] components = (List<Integer>[]) new List[ccNum];
        // 把顶点归入属于自己的连通分量中
        for (int i = 0; i < ccNum; i ++) {
            int id = cc.id(ccNum);  // 获取连通分量标记：id
            components[i] = new LinkedList<>();
            for (int v = 0; v < G.V(); v ++) {
                if (cc.id[v] == i){
                    components[i].add(v);
                }
            }
        }
        // 输出连通分量数目
        System.out.println(ccNum+" components");
        // 输出各个连通分量
        for (int i = 0 ; i < components.length; i ++) {
            for (int w: components[i]) {
                System.out.print(w+" ");
            }
            System.out.println();
        }
    }

}
