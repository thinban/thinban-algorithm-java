package com.thinban.array;

import cn.hutool.core.lang.Console;
import com.thinban.base.Ut;

import java.util.Arrays;

public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int q = 0;
        int t = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                //重复出现的数
                q = nums[i];
            }
            if (t == nums[i]) {
                //丢失的数字
                t++;
            }
        }
        return new int[]{q, t};
    }

    public static void main(String[] args) {
        Console.log(new FindErrorNums().findErrorNums(Ut.buildArr(1, 2, 2, 4)));//2,3
        Console.log(new FindErrorNums().findErrorNums(Ut.buildArr(1, 1)));//1,2
        Console.log(new FindErrorNums().findErrorNums(Ut.buildArr(2, 2)));//2,1
        Console.log(new FindErrorNums().findErrorNums(Ut.buildArr(3, 2, 3, 4, 6, 5)));//3,1
        Console.log(new FindErrorNums().findErrorNums(Ut.buildArr(1, 5, 3, 2, 2, 7, 6, 4, 8, 9)));//2,10
    }
}
