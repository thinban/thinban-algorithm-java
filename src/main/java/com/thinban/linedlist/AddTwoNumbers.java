package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

import java.util.Stack;

/**
 * 两数相加
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //入栈
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        //计算
        boolean flag = false;
        int i = 0, j = 0, val = 0;
        ListNode tmp = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                i = s1.pop();
            } else {
                i = 0;
            }
            if (!s2.isEmpty()) {
                j = s2.pop();
            } else {
                j = 0;
            }

            val = i + j;
            if (flag) {
                val += 1;
                flag = false;
            }
            if (val >= 10) {
                val -= 10;
                flag = true;
            }

            //link
            ListNode res = new ListNode(val);
            res.next = tmp;
            tmp = res;
        }
        if (flag) {
            ListNode res = new ListNode(1);
            res.next = tmp;
            tmp = res;
        }
        return tmp;
    }

    public static void main(String[] args) {
//        Ut.printListNode(new AddTwoNumbers().addTwoNumbers(Ut.buildListNode(5), Ut.buildListNode(5)), false);
        Ut.printListNode(new AddTwoNumbers().addTwoNumbers(Ut.buildListNode(1), Ut.buildListNode(9, 9)), false);
        Ut.printListNode(new AddTwoNumbers().addTwoNumbers(Ut.buildListNode(5, 6, 4), Ut.buildListNode(7, 2, 4, 3)), false);
    }
}
