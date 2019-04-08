package com.gakki.chapter4.bfs;

import java.util.*;

/**
 * @author wangxiaobin
 */
public class DFS {
    public static void main(String[] args) {
        G g = new G();
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        g.addEdge(A,B);
        g.addEdge(A,C);
        g.addEdge(C,B);
        g.addEdge(D,B);
        g.addEdge(C,D);
        g.addEdge(D,E);
        g.addEdge(C,E);
        g.addEdge(D,F);

        Stack<Node> stack = new Stack<>();
        stack.push(A); //把A入队列
        A.setMarked(true);  // 并且把A的访问标记设置为true，防止重复

        while(!stack.isEmpty()){
            Node o = stack.pop();

            System.out.print(o.getName()+"\t");

            List<Node> list = g.getAdj(o);
            for (Node n : list) {
                if (!n.isMarked()) {
                    // 没有被访问过
                    stack.push(n);
                    n.setMarked(true);
                }
            }
        }
    }

}
