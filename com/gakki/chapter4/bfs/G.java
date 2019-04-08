package com.gakki.chapter4.bfs;

import java.util.*;

/**
 * @author wangxiaobin
 */
public class G {
    private int vertex;	// 定点数
    private int egde;	// 边数

    private Map<Node,List<Node>> adj;	// 邻接表

    public G(){
        vertex = 0;
        egde = 0;
        adj = new HashMap<>();
    }

    /*添加 name1 -- name2(双向) 的边*/
    public void addEdge(Node Node_1, Node Node_2){

        if (adj.containsKey(Node_1)) {
            adj.get(Node_1).add(Node_2);
        }
        else {
            List<Node> l = new LinkedList<>();
            l.add(Node_2);
            adj.put(Node_1,l);
        }

        if (adj.containsKey(Node_2)) {
            adj.get(Node_2).add(Node_1);
        }
        else {
            List<Node> l = new LinkedList<>();
            l.add(Node_1);
            adj.put(Node_2,l);
        }

        vertex = adj.size();
        egde ++;
    }

    public List<Node> getAdj(Node n){
        return adj.get(n);
    }
}
