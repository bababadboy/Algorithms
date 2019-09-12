package com.gakki.leetcode.problemset.algorithms.T_179;

/**
 * @author wangxiaobin
 */
class Solution {
    public static void main(String[] args) {
        int[] a = {3,30};
        Solution s = new Solution();
        System.out.println(s.largestNumber(a));

    }

    public String largestNumber(int[] nums) {
        boolean isAllZero = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                isAllZero = false;
        }

        if (isAllZero)
            return "0";


        StringBuilder sb = new StringBuilder();
        mySort(nums);

        for(int i =0; i < nums.length;i++){
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    /**
     * 降序排列
     */
    private void mySort(int[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j ++){
                if(compare(a[i],a[j]) < 0){
                    // a_i < a_i
                    exch(a,i,j);
                }
            }
        }
    }
    private void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /*a == b:0; a > b : 1; a < b:-1*/
    private int compare(int a , int b) {
        if (a == b)
            return 0;
        String s1 = "";
        s1 = s1+a+b;
        String s2 = "";
        s2 = s2+b+a;
        return s1.compareTo(s2);

    }

    private int[] int2Array(int a){
        int digitLen = 0;
        int t = a;
        while(t > 0){
            t = t / 10;
            digitLen ++;
        }

        int[] arr = new int[digitLen];
        t = a;
        int i = digitLen - 1;
        while(t > 0){
            arr[i] = t % 10;
            t = t / 10;
            i --;
        }

        return arr;
    }
}