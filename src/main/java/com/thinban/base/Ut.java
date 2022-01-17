package com.thinban.base;

import java.util.Arrays;

/**
 * @author chenshengbin
 * @date 2022/1/4 10:43
 */
public class Ut {


    public static ListNode buildListNode(int... vals) {
        ListNode listNode = null;
        ListNode head = null;
        for (int val : vals) {
            if (listNode == null) {
                head = listNode = new ListNode(val);
            } else {
                ListNode tmp = new ListNode(val);
                listNode.next = tmp;
                listNode = listNode.next;
            }
        }
        return head;
    }

    public static void printListNode(ListNode p) {
        printListNode(p, true);
    }

    public static void printListNode(ListNode p, boolean enter) {
        printListNode(new ListNode[]{p}, enter);
    }

    public static void printListNode(ListNode[] p) {
        printListNode(p, false);
    }

    public static void printListNode(ListNode[] pp, boolean enter) {
        for (ListNode p : pp) {
            while (p != null) {
                if (enter) {
                    System.out.println(p.val);
                } else {
                    System.out.print(p.val);
                }
                p = p.next;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[] buildArr(int... vals) {
        return vals;
    }

    public static void printArr(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static long printCost(long start) {
        long now = System.currentTimeMillis();
        System.out.println((now - start) / 1000);
        return now;
    }


    /**
     * 二分查询
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

