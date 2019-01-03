package com.gakki.leetcode;

import java.util.*;

/**
 * @author wangxiaobin
 */
public class ArrayAndSort {
    public static void main(String[] args){
        int[] array = new int[]{-1, 0, 1, 2, -2,-4};
//        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(twoSum(array,0));
    }

    /**
     * 两数之和为target，不存在返回null
     */
    public static List<List<Integer>> twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list;         // 用来存储两个加数
        int[] twoNums;
        List<List<Integer>> listList = new ArrayList<>();   // 存储list

        for (int i = 0; i < nums.length; i ++ ){
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i ++){
            if (map.containsKey(target - nums[i])   // nums[i] + map中的键（这个键是nums数组的值）== target
                    && i != map.get(target - nums[i])){ // 去除同一个的可能性
                list = new ArrayList<>();
                list.add(nums[i]);
                list.add(target - nums[i]);
                listList.add(list);
                map.remove(nums[i]);                // 删除已经匹配过的两个数
                map.remove(target - nums[i]);
            }
        }

        return listList;
    }

    /**
     * 三数之和等于0
     */
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list;

        for (int i = 0; i < nums.length; i ++){
            for (int j = i + 1; j < nums.length; j ++){
                for (int k = j + 1; k < nums.length; k ++){
                    if (nums[i]+ nums[j] + nums[k] == 0){
                        list = new ArrayList<>() ;
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        listList.add(list);
                    }
                }
            }
        }
        return listList;
    }
}
