package com.gakki.leetcode.problemset.T_973;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * @author wangxiaobin
 */
public class Solution {
    public static void main(String[] args) {
        int[][] a = {{3,1},{2,-2},{1,1}};
        new Solution().kClosest(a,2);
    }
    public int[][] kClosest(int[][] points, int K) {
        // 顶点个数
        int cnt = points.length;

        // 距离的平方，第0个不用
        int[] dis = new int[cnt + 1];
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 2; j++) {
                dis[i+1] += points[i][j]*points[i][j];
            }
        }
        // 顶点索引对应的小顶堆
        int[] bigHeap = new int[cnt + 1];
        // 初始化堆
        for (int i = 0; i < cnt + 1; i++) {
            bigHeap[i] = i;
        }

        // 根据距离构建小顶堆
        for (int k = cnt / 2; k > 0 ; k --) {
            sink(bigHeap,dis,k,cnt);
        }
        // 输出前K个最小距离的索引
        int[] sortIdx = new int[K];
        sortIdx[0] = bigHeap[1] - 1;
        int n = cnt;
        for (int i = 1; i < K; i++) {
            swap(bigHeap,1,n --);
            sink(bigHeap,dis,1,n);
            sortIdx[i] = bigHeap[1] - 1;// 减1是把索引对齐
        }
        // 结果返回
        int[][] res = new int[K][];
        for (int i = 0; i < K; i++) {
            res[i] = Arrays.copyOf(points[sortIdx[i]],2);
        }
        return res;

    }


    /**
     * 根据dis下沉a
     * @param a 需要修改的val数组
     * @param dis 需要比较的dis数组
     * @param k 第k个元素
     */
    private void sink(int[] a,int[] dis, int k,int last){
        while (2 * k <= last){
            int j = 2 * k;
            // 找到两节点中较小的节点
            if (j < last && dis[a[j]] > dis[a[j+1]])
                j ++;
            if (dis[a[j]] >= dis[a[k]])
                break;
            swap(a,k,j);
            k = j;
        }
    }
    private void swap(int[] arr, int i , int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
