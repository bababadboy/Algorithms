package com.gakki.nowcoder.剑指offer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 * @author wangxb XD
 * @date 2019-08-18
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        String s = "We Are Very  Happy";
        StringBuffer sb = new StringBuffer(s);
        System.out.println(new ReplaceSpace().replaceSpace(sb));


        System.out.println(new String(new ReplaceSpace().repplaceSpce(s.toCharArray())));
    }

    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        return s.replaceAll(" ","%20");
    }


    /**
     * 不用String的方法做
     */
    public char[] repplaceSpce(char[] chars){

        int spaceCount = 0;

        for (char c : chars) {
            if (c == ' '){
                spaceCount ++;
            }
        }
        // ' '->'%20'，多了两个
        int newLen = chars.length + 2*spaceCount;
        char[] res = new char[newLen];

        // 双指针
        for (int i = 0,j=0; i < chars.length; i++) {
            if (chars[i] == ' '){
                res[j++] = '%';
                res[j++] = '2';
                res[j++] = '0';
            }else {
                res[j++] = chars[i];
            }
        }
        return res;

    }
}
