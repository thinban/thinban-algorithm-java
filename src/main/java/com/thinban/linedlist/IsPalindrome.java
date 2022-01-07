package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

import java.util.Stack;

/**
 * 判断链表是否回文
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s1 = new Stack<>();
        ListNode t = head;
        while (head != null) {
            s1.push(head.val);
            head = head.next;
        }
        if (s1.size() < 1) return false;
        //比较
        while (t != null) {
            if (s1.pop() != t.val) return false;
            t = t.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome(Ut.buildListNode(1, 2, 2, 1)));
        System.out.println(new IsPalindrome().isPalindrome(Ut.buildListNode(1, 3, 2, 1)));
        System.out.println(new IsPalindrome().isPalindrome(Ut.buildListNode()));
        System.out.println(new IsPalindrome().isPalindrome(Ut.buildListNode(1)));
        System.out.println(new IsPalindrome().isPalindrome(Ut.buildListNode(1, 2)));
    }
}
