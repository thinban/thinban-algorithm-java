package com.thinban.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenshengbin
 * @date 2022/1/14 15:54
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        Set<Integer> set1 = new HashSet();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            set1.add(i);
        }
        set.retainAll(set1);
        return set.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        final int[] intersection = new Intersection().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        final int[] intersection1 = new Intersection().intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println();
    }
}
