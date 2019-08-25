package com.gakki.Algroithms4th.chapter5;

/**
 * @author wangxb (O_o)??)
 * @date 2019-07-04
 * Boyer-Moore字符串匹配算法:1.倒序匹配2.坏字符规则3.好后缀规则 // todo : (
 */
public class BM {
    public final static int N = 128;        // ascii字符表个数
    public static int[] bc = new int[N];  //   存储模式串每个字符的最大的位置

    public static void main(String[] args) {

        String s = "aaabaaabaaab";
        String pattern = "aaaa";

        /* 创建模式串字符位置，便于快速查询
        如：快速查询 pattern = "aaabbcd"中a的位置
         */
        createBC(pattern);

        int idx = search(s,pattern);

        System.out.println(pattern+"在"+s+"中的位置是:"+idx);
    }

    private static void createBC(String pattern) {

        for (int i = 0; i < bc.length; i++) {
            bc[i] = -1;
        }

        for (int i = 0; i < pattern.length(); i++) {
             bc[(int)pattern.charAt(i)] = i;
        }
    }

    private static int search(String s,String pattern) {

        // 返回坏字符规则和好后缀规则的最大值
//        return badChar(s,pattern);
        return goodSuffix(s,pattern);
//        return Math.max(badChar(s,pattern),goodSuffix(s,pattern));
    }

    private static int goodSuffix(String s, String pattern) {

        // 建立int[]:suffix数组,boolean[]:prefix数组
        int pLen = pattern.length();
        int[] suffix = new int[pLen];  // suffix[0] 不用
        boolean[] prefix = new boolean[pLen];  // prefix[0] 不用

        // 初始化
        for (int i = 0; i < pLen; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        for (int i = 0; i < pLen-1; i++) { // 若是：i == p-1, j == p -1, pattern[p-1]==pattern[p-1] always true ==> suffix[1]=p-1,错误,后缀长度为1的下标不能是自己
            int j = i;
            int k  = 0;     // 公共后缀子串的长度，初始为0
            while (j >= 0 && pattern.charAt(j) == pattern.charAt(pLen-1 - k)){
                -- j;
                ++ k;   // 公共后缀子串的长度加一
                suffix[k] = j + 1;   // 更新suffix数组
            }
            if (j == -1){   // 达到了前缀的标准
                prefix[k] = true;
            }
        }
        for (int i = pLen/2+1; i < pLen; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        // 建立完成

        int sLen = s.length();
        // 开始匹配主串和模式串
        for (int i = 0; i <= sLen - pLen; i++) {
            int j = pLen - 1;
            int goodSufLen = 0; // goodSufLen=好后缀的长度
            for (;j >= 0 && s.charAt(i + j) == pattern.charAt(j); j--,goodSufLen ++){}

            if (suffix[goodSufLen] != -1){
                // 存在另一个好后缀
                i += pLen - goodSufLen - suffix[goodSufLen];
            }else{
                for (int suf = goodSufLen - 1; suf > 0; suf --){
                    if (prefix[suf]){
                        i += pLen - suf - 1;
                    }
                }
            }
            if (j == 0){    // 如果模式串全部匹配完毕
                return i;
            }
        }
        return -1;
    }

    private static int badChar(String s, String pattern) {
        int m = s.length();
        int p = pattern.length();
        // 从后开始匹配
        int i = 0;
        while (i < m - p + 1){
            for (int j = p - 1; j >= 0; j --) {
                if (pattern.charAt(j) != s.charAt(i + j)){
                    // 不匹配
                    int idxInPattern = bc[s.charAt(i + j)];
                    // i的跨度由idxPattern决定
                    i += (idxInPattern == -1 ? j+1 : (j - idxInPattern));
                    break;
                }
                if (j == 0){
                    return i;
                }
            }
        }
        return -1;
    }

}
