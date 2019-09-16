package com.gakki.leetcode.questions_easy.string;


import java.util.LinkedHashMap;

/**
 * @author wangxb XD
 * @date 2019-09-15
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer[]> map = new LinkedHashMap<>(s.length());
        char[] chs = s.toCharArray();
        for(int i  = 0;i<s.length();i++){
            if(map.containsKey(chs[i])){
                int cnt = map.get(chs[i])[0]+1;
                map.put(chs[i],new Integer[]{cnt,i});
            }else{
                map.put(chs[i],new Integer[]{1,i});
            }
        }
        for(Character c: map.keySet()){
            if(map.get(c)[0]==1){
                return map.get(c)[1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("dddccdbba"));
    }
}
