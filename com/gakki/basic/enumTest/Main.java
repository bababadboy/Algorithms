package com.gakki.basic.enumTest;

/**
 * @author wangxiaobin
 */
public class Main {
    public static void main(String[] args) {
        Seasons spring = Seasons.SPRING;
        for (Seasons season:Seasons.values()
             ) {
            System.out.println(season+" "+season.getTemperature());
        }

        Enum<Seasons> seasonsEnum = Seasons.SPRING;
    }

}
