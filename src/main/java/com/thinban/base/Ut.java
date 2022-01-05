package com.thinban.base;

/**
 * @author chenshengbin
 * @date 2022/1/4 10:43
 */
public class Ut {
    public static ListNode buildListNode(int... vals) {
        ListNode listNode = null;
        ListNode head = null;
        for (int val : vals) {
            if (listNode == null) {
                head = listNode = new ListNode(val);
            } else {
                ListNode tmp = new ListNode(val);
                listNode.next = tmp;
                listNode = listNode.next;
            }
        }
        return head;
    }

    public static void printListNode(ListNode p) {
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
