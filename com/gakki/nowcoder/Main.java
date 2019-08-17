package com.gakki.nowcoder;

import java.util.Scanner;

/**
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶
 * ，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
 * 喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，
 * 喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * @author wangxb (O_o)??)
 * @date 2019-08-11
 */
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){

            int bottles = sc.nextInt();
            if (bottles == 0){
                // 输入结束
                break;
            }
            int drinked = 0;
            while(bottles-3>=0){
                ++ drinked;
                bottles-=2;
            }
            if(bottles == 2){
                // 最后只剩两个空瓶
                ++ drinked;
            }
            System.out.println(drinked);
        }
    }
}
