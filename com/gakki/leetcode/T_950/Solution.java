package com.gakki.leetcode.T_950;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reveal-cards-in-increasing-order/comments/
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = new int[]{2,3,5,7,13,17};
        int[] res = s.deckRevealedIncreasing(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(res[i]);
        }
    }
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        for(int i = deck.length - 2;i>0;i--){
            change(deck,i);
        }
        return deck;
    }
    private void change(int[] deck ,int index){
        int lastValue = deck[deck.length - 1];
        for(int i = deck.length - 2;i>=index;i--){
            deck[i+1] = deck[i];
        }
        deck[index] = lastValue;
    }
}
