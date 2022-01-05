package com.thinban.base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}