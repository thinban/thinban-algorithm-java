package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

/**
 * 交换链表相邻的两个节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author chenshengbin
 * @date 2022/1/6 18:44
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        Ut.printListNode(new SwapPairs().swapPairs(Ut.buildListNode(1, 2, 3, 4, 5, 6)));//3,1,4,2
    }
}
