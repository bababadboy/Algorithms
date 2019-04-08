package com.gakki.chapter4.bfs;

import java.util.*;
/**
 * @author wangxiaobin
 */
public class BFS {
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

        Queue<Node> queue = new LinkedList<>();
        queue.offer(A); //把A入队列
        A.setMarked(true);  // 并且把A的访问标记设置为true，防止重复
        // 最短路径前一节点保存
        Map<Node,Node> parents = new HashMap<>();
        parents.put(A,null);


        while(!queue.isEmpty()){
            Node o = queue.poll();

            System.out.print(o.getName()+"\t");

            List<Node> list = g.getAdj(o);
            for (Node n : list) {
                if (!n.isMarked()) {
                    // 没有被访问过
                    queue.add(n);
                    parents.put(n,o);
                    n.setMarked(true);
                }
            }
        }
        System.out.println();

        // A 到 E 的最短距离
        Node to = E;
        Stack<String> stack = new Stack<>();
        stack.push(to.getName());
        while (parents.get(to)!=null){
            stack.push(parents.get(to).getName());
            to = parents.get(to);
        }
        while (!stack.empty()){
            System.out.print(stack.pop()+"\t");
        }

    }

}
