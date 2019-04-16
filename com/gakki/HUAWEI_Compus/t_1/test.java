package com.gakki.HUAWEI_Compus.t_1;

/**
 * @author wangxiaobin
 */
public class test {
    public static void main(String[] args) {
        int size = 2;
        String[] res = new String[size];
        String s = "123456789";
        int cutNo = 0;
        int cutFrom = 0;
        while (cutNo < size){
            if (cutFrom+8 < s.length())
                res[cutNo] = s.substring(cutFrom,cutFrom+8);
            else {
                res[cutNo] = s.substring(cutFrom,s.length());
                int diff = 8 - res[cutNo].length();
                res[cutNo] = addZero(res[cutNo],diff);
            }
            System.out.println(res[cutNo]);
            cutNo ++;
            cutFrom += 8;
        }
    }
    private static String addZero(String s, int i) {
        StringBuilder sb = new StringBuilder(s);
        for (int j = 0; j < i; j++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
