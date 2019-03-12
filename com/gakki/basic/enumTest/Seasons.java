package com.gakki.basic.enumTest;

import java.lang.Enum;
/**
 * @author wangxiaobin
 */
public enum Seasons {
    SPRING("warm",1),SUMMER("hot",2),AUTUMN("cool",3),WINTER("freeze",4);

    private String temperature;
    private int index;

    Seasons(String temperature, int index) {
        this.temperature = temperature;
        this.index = index;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
