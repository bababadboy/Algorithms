package com.gakki;


/**
 * 单词翻转 "I like playing games" ==> "games playing like I"
 * 空间复杂度为1
 * @author wangxb XD
 * @date 2019-08-25
 */
public class WordReverse {

    private static final char SPACE =' ';
    public static void main(String[] args) {

        String s = "I like playing games";
        char[] chars = s.toCharArray();
        // 思路
        // 1. 首先整个句子字母翻转==>semag gniyalp ekil I
        // 2. 遇到空格，把空格前的单词翻转==> games playing like I
        reverseAll(chars);

        System.out.println(new String(chars));

    }

    private static void print(char[] chars) {
        for (char aChar : chars) {
            System.out.print(aChar + " ");
        }
    }

    private static void reverseAll(char[] chars) {
        for (int i = 0; i < chars.length/2; i++) {
            exchange(chars,i,chars.length - i - 1);
        }

        for (int start = 0,end=0; end < chars.length; end ++) {
            if (chars[end] == SPACE){
                // 单词内的翻转
                for (int i = start,count = 0; i < start+(end -start)/2; i ++,count++){
                    exchange(chars,i,end-count-1);
                }
                start = end + 1;
                end = start;
            }
        }
    }

    private static void exchange(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
