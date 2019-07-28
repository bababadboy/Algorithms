package com.gakki.basic.stream;


import java.util.Calendar;
import java.util.Date;

public class DataEntiy {

    private int id;

    private String name;

    private int age;

    private short status;   // 0,1-default

    private String createTime;

    private String updateTime;

    public DataEntiy(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = 1;
        this.createTime = String.valueOf(new Date().getTime());
        this.updateTime = String.valueOf(new Date().getTime());
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DataEntiy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
