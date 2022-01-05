package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

/**
 * 合并两个升序链表:双指针思想
 *
 * @author chenshengbin
 * @date 2022/1/5 17:16
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //双指针思想
        ListNode p = new ListNode();
        ListNode head = p;
        while (list1 != null && list2 != null) {
            if (list1.val == list2.val) {
                p.next = list1;
                p = p.next;
                list1 = list1.next;

                p.next = list2;
                p = p.next;
                list2 = list2.next;
            } else if (list1.val > list2.val) {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            } else {
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }
        }
        //补充剩下的
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        return head.next == null ? null : head.next;
    }

    public static void main(String[] args) {
        Ut.printListNode(new MergeTwoLists().mergeTwoLists(Ut.buildListNode(1, 2, 4), Ut.buildListNode(1, 3, 4)));
        Ut.printListNode(new MergeTwoLists().mergeTwoLists(null, Ut.buildListNode(0)));
    }
}
