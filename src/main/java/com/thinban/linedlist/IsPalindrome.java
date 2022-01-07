package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        //todo  反转后head.next=null
        ListNode r = revert(t.next);
        while (head != null && r != null) {
            if (head.val != r.val) {
                return false;
            }
            head = head.next;
            r = r.next;
        }
        return true;
    }

    public static ListNode revert(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = revert(head.next);
        head.next.next = head;
        head.next = null;
        return h;
    }

    public static void main(String[] args) {
//        System.out.println(new IsPalindrome().isPalindrome(Ut.buildListNode(1, 2, 2, 1)));
        System.out.println(new IsPalindrome().isPalindrome(Ut.buildListNode(1, 3, 2, 1)));
    }
}
