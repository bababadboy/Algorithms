package com.gakki.leetcode.byteDance.arrayAndSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * wa..
 * @author wangxiaobin
 */
class ThreeSumNoRepeat {
    public static void main(String[] args) {
        ThreeSumNoRepeat s = new ThreeSumNoRepeat();
//        int[] arr = {-1,0,1,2,-1,-4};
        int[] arr = {1,0,-1,0};
//        int[] arr = {0,0,0,0};
        List l = s.threeSum(arr);
        System.out.println(l);
    }

    /**
     * 有则返回idx,无则返回-1
     */
    private int binarySearch(int[] nums,int from, int target) {
        int lo = from;
        int hi = nums.length - 1;
        int mid = lo + (hi - lo) / 2;
        while(lo <= hi) {
            if(target < nums[mid]){
                hi = mid - 1;
            }
            else if(target > nums[mid]) {
                lo = mid + 1;
            }
            else {
                return mid;
            }
            mid = lo + (hi - lo) / 2;
        }
        return -1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> llist = new ArrayList<>();
        for(int i =0; i < nums.length-2; i ++) {
            // 优化重复的nums[i]
            while (i > 0 && nums[i-1]==nums[i] && i < nums.length-3)
                i ++;

            for(int j = i + 1; j < nums.length-1; j ++) {
                // 优化重复的nums[j]
                while (j > 1 && nums[j] == nums[j+1] && j< nums.length-1)
                {
                    j ++;
                    if (j == nums.length-1)
                        break;
                }
                // 如果j移动到了最后一个元素，意味着不存在了
                if (j == nums.length-1){
                    break;
                }
                List<Integer> l = new ArrayList<>();
                if (binarySearch(nums,j+1,-nums[i]-nums[j]) > 0) {
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(-nums[i]-nums[j]);
                    llist.add(l);
                }
            }
        }
        return llist;
    }
}
