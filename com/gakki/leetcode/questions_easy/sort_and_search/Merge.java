package com.gakki.leetcode.questions_easy.sort_and_search;

/**
 * @author wangxb (O_o)??)
 * @date 2019-09-07
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;

        if(n == 0){
            return;
        }
        if(m == 0){
            arraycopy(nums2,0,nums1,0,n);
            return;
        }

        int[] res = new int[m+n];
        int c = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                res[c++] = nums1[i++];
            }else{
                res[c++] = nums2[j++];
            }
        }
        while(i < m){
            res[c++] = nums1[i++];
        }
        while(j < m){
            res[c++] = nums2[j++];
        }
        arraycopy(res,0,nums1,0,m+n);

    }
    private void arraycopy(int[] from,int srcFrom,int[] to,int desFrom,int len){
        for(int x = srcFrom,y = desFrom; x < srcFrom+len; x ++,y++){
            to[x] = from[y];
        }
    }
}
