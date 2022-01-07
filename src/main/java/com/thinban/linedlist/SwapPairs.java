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
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode p = head, q = head.next, t = null;
        ListNode v = new ListNode();
        v.next = p;
        boolean first = false;
        while (p != null && p.next != null) {
            t = q.next;
            if (v.next == head) {
                first = true;
            }
            //交换两个节点
            v.next = q;
            q.next = p;
            p.next = t;

            //首次交换，修改head位置
            if (first) {
                head = q;
                first = false;
            }

            //移动指针位置
            v = p;
            p = p.next;
            if (p != null) q = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        Ut.printListNode(new SwapPairs().swapPairs(Ut.buildListNode(1, 2, 3, 4, 5, 6)));//2,1,4,3,6,5
        Ut.printListNode(new SwapPairs().swapPairs(Ut.buildListNode()));//null
    }
}
