package com.thinban.array;

import com.thinban.base.Ut;

public class MoveZeroes {
    /**
     * 11.37%,6 ms
     * 26.37%,39.8 MB
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zeroCnt = 0;
        //倒序，发现0后，移动数组（ps:冒泡会超时)
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                //数组拷贝
                System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i - zeroCnt);
                nums[nums.length - 1 - zeroCnt] = 0;
                zeroCnt++;
            } else {
                continue;
            }
        }
    }

    public static void main(String[] args) {
//        int[] ints = Ut.buildArr(0, 1, 0, 3, 12);
        int[] ints = Ut.buildArr(45192, 0, -659, -52359, -99225, -75991, 0, -15155, 27382, 59818, 0, -30645, -17025, 81209, 887, 64648);
        long start = System.currentTimeMillis();
        new MoveZeroes().moveZeroes(ints);
        Ut.printCost(start);
        Ut.printArr(ints);
    }
}
