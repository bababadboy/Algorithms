package com.gakki.basic.multiThreading.eatCake;

/**
 * @author wangxiaobin
 */
public class Cake {
    private int size;

    public Cake(int size) {
        this.size = size;
    }

    public void eatCake(int n) {
        if (size - n >= 0){
            size -= n;
        }
        else // size - n < 0:不够吃了
        {
            size = 0;
        }
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
