package com.gakki.leetcode.questions_easy.array;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @author wangxb XD
 * @date 2019-09-17
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        initmap(map,nums1);
        initmap(map2,nums2);
        Set<Integer> set = map.keySet();
        Set<Integer> set2 = map2.keySet();
        // 交集运算
        set.retainAll(set2);
//        int[] res = new int[set.size()];
        List<Integer> list = new LinkedList<>();
        for (Integer key : set) {
            int cnt = Math.min(map.get(key),map2.get(key));
            for (int i = 0; i < cnt; i++) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    public int[] intersectQuick(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[list.size()];
        for(i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    private void initmap(Map<Integer, Integer> map, int[] nums1) {
        for (int i : nums1) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            int cnt = map.get(i) + 1;
            map.put(i,cnt);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,2,1};
        int[] b = new int[]{2,2};
        int[] res = new Intersect().intersect(a,b);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
