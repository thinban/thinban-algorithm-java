package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

/**
 * 删除重复节点
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        ListNode t = null;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                //移除节点p.next
                t = p.next.next;
                p.next.next = null;
                p.next = t;
            } else {
                //移动指针
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new DeleteDuplicates().deleteDuplicates(Ut.buildListNode(1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 3));
        Ut.printListNode(listNode);
    }
}
