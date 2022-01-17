package com.thinban.array;

import cn.hutool.core.lang.Console;
import com.thinban.base.Ut;

import java.util.ArrayList;
import java.util.List;

public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        //先找出度和计量度的数（数组）
        List<DD> list = new ArrayList<>();
        int maxD = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            DD dd = new DD(nums[i], i);
            int d = 1;
            int end = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    d++;
                    end = j;
                }
                if (d > maxD) {
                    maxD = d;
                }
            }
            dd.setD(d);
            dd.setEnd(end);
            list.add(dd);
        }
        int shortLen = Integer.MAX_VALUE;
        for (DD dd : list) {
            if (dd.getD() == maxD && dd.getEnd() > dd.getFrom() && dd.getEnd() - dd.getFrom() < shortLen) {
                shortLen = dd.getEnd() - dd.getFrom();
                Console.log("{}-{}-[{},{}]", dd.getNum(), dd.getD(), dd.getFrom(), dd.getEnd());
            }
        }
        return shortLen == Integer.MAX_VALUE ? 1 : shortLen + 1;
    }

    private static class DD {
        private int num;
        private int d;
        private int from;
        private int end;


        public DD(int num, int from) {
            this.num = num;
            this.from = from;
        }

        public DD(int num, int d, int from, int end) {
            this.num = num;
            this.d = d;
            this.from = from;
            this.end = end;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public static void main(String[] args) {
//        Console.log(new FindShortestSubArray().findShortestSubArray(Ut.buildArr(1, 2, 2, 3, 1)));
        Console.log(new FindShortestSubArray().findShortestSubArray(Ut.buildArr(1, 2, 2, 3, 1, 4, 2)));
    }
}
