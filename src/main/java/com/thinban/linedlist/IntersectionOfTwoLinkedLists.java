package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

/**
 * 链表相交
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 原理：两个指针，通过循环（尾部后指向另一个链表）消除距离差，最终到达相交点或者指向最后的null
 *
 * @author chenshengbin
 * @date 2022/1/4 10:18
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            //通过循环，消除距离差，最终到达相交点或者指向最后的null
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public static void main(String[] args) {
        ListNode headA = Ut.buildListNode(1, 2, 3, 4);
        ListNode headB = Ut.buildListNode(9);
        //拼接到相同节点上
        ListNode same = Ut.buildListNode(5, 6);
        ListNode pa = headA, pb = headB;
        while (pa.next != null) {
            pa = pa.next;
        }
        pa.next = same;
        while (pb.next != null) {
            pb = pb.next;
        }
        pb.next = same;

        final ListNode intersectionNode = new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headB);
        Ut.printListNode(intersectionNode);
    }
}
