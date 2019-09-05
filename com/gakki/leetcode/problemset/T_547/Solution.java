package com.gakki.leetcode.problemset.T_547;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 * 转换成求图的连通子图个数
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
//        int[][] arr = {{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};
        int[][] arr = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(arr));
    }

    public static int findCircleNum(int[][] M) {
        // 求连通子图的个数
        int len = M.length;


        // 朋友圈数组，val意味着朋友圈的编号
        int[] friendsArr = new int[len];
        // 初始化朋友圈，初始状态：自己是自己的朋友
        for (int i = 0; i < len; i++) {
            friendsArr[i] = i;
        }

//        Map<Integer,List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < len; i++) {
//            List<Integer> l = new ArrayList<>();
//            l.add(i);
//            map.put(i,l);
//        }

        for (int i = 0; i < len; i++) {
            // 对称矩阵，优化遍历
            for (int j = i + 1; j < len; j++) {
                if (M[i][j] == 1)
                {
                    // 把 j以及j的朋友 都变为 i 的朋友
                    List<Integer> friendsOfJ = findFriends(friendsArr,j);
                    for (int f : friendsOfJ) {
                        friendsArr[f] = friendsArr[i];
                    }
                    // 如果 i 和 j 是朋友
//                    map.get(i).add(j);
//                    map.get(j).add(i);

//                    List<Integer> friendsOfJ = map.get(j);

//                    for (int f: friendsOfJ) {
//                        // 把 j以及j的朋友 都变为 i 的朋友
//                        friendsArr[f] = friendsArr[i];
//                    }
                }
            }
        }

        // 朋友圈个数
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(friendsArr[i]);
        }
        return set.size();
    }

    private static List<Integer> findFriends(int[] friendsArr, int j) {
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < friendsArr.length; i++) {
            if (friendsArr[i] == friendsArr[j])
                // 把索引加入链表
                l.add(i);
        }
        return l;
    }
}
