package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

/**
 * 删除链表的倒数第 N 个结点
 * 原理：设置间隔为n的双指针，若q==null,说明移除首节点；否则同时移动pq，直到q.next==null,此时移除p.next即可
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            q = q.next;
        }

        //移除首结点
        if (q == null) {
            return head.next;
        }

        //同时移动
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        //移除p.next
        ListNode next = p.next.next;
        p.next = next;
        return head;
    }

    public static void main(String[] args) {
        Ut.printListNode(new RemoveNthFromEnd().removeNthFromEnd(Ut.buildListNode(1, 2, 3, 4, 5), 2));//1,2,3,5
        Ut.printListNode(new RemoveNthFromEnd().removeNthFromEnd(Ut.buildListNode(1), 1));//[]
        Ut.printListNode(new RemoveNthFromEnd().removeNthFromEnd(Ut.buildListNode(1, 2), 2));//1
    }
}
