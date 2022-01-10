package com.thinban.array;

import com.thinban.base.Ut;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        //思想：数组的索引和域连接成一个环形链表，重复数即存在环
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //此时slow=fast，即处于环的入口。
        // //TODO 为什么到从这个点到重复数的距离会和起点到重复数会一样呢？
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

    public static void main(String[] args) {
//        int duplicate = new FindDuplicate().findDuplicate(Ut.buildArr(1, 3, 4, 2, 2));
        int duplicate = new FindDuplicate().findDuplicate(Ut.buildArr(3, 1, 3, 4, 2));
        int duplicate1 = new FindDuplicate().findDuplicate(Ut.buildArr(2, 5, 9, 6, 9, 3, 8, 9, 7, 1));
    }


}
