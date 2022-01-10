package com.thinban.array;

import cn.hutool.core.lang.Console;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        //采用优先队列实现小根堆
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int[] ints : matrix) {
            for (int e : ints) {
                minHeap.add(e);
            }
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = minHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int[][] b = {{-5}};
        Console.log(new KthSmallest().kthSmallest(a, 8));
        Console.log(new KthSmallest().kthSmallest(b, 1));
    }
}
