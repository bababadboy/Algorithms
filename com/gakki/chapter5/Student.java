package com.gakki.chapter5;

/**
 * @author wangxiaobin
 */
public class Student {
    private String name;
    private int goupNo;

    public Student(String name, int goupNo) {
        this.name = name;
        this.goupNo = goupNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoupNo() {
        return goupNo;
    }

    public void setGoupNo(int goupNo) {
        this.goupNo = goupNo;
    }
}
