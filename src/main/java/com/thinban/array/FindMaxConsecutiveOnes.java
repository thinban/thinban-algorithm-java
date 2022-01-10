package com.thinban.array;

import cn.hutool.core.lang.Console;
import com.thinban.base.Ut;

public class FindMaxConsecutiveOnes {
    /**
     * 给定一个二进制数组， 计算其中最大连续 1 的个数。
     * 输入：[1,1,0,1,1,1]
     * 输出：3
     * 2 ms 57.37%
     * 39.8 MB 57.98%
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                tmp = 0;
            } else {
                tmp++;
                if (tmp > max) max = tmp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Console.log(new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(Ut.buildArr(1, 1, 0, 1, 1, 1)));
    }
}
