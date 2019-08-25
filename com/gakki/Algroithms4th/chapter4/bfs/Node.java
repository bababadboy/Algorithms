package com.gakki.Algroithms4th.chapter4.bfs;

/**
 * @author wangxiaobin
 */
public class Node {
    private String name;
    private Node parent;    // 最短路径的前一节点
    private boolean marked; // 标记信息

    public Node(String name){
        this.name = name;
        marked = false;
    }
    public Node(String name,boolean marked){
        this.name = name;
        this.marked = marked;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setMarked(boolean marked){
        this.marked = marked;
    }

    public String getName(){
        return name;
    }
    public boolean isMarked(){
        return marked;
    }
}
