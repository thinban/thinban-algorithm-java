package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

/**
 * @author chenshengbin
 * @date 2022/1/5 14:04
 */
//四种思路：1. 新增头结点，遍历插入。 2.新增头结点，元素调换位置。 3. 三个指针  4.递归
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode p = null, q = head, n = null;
        while (q != null) {
            //存
            n = q.next;
            //换方向
            q.next = p;
            //移位
            p = q;
            q = n;
        }
        return p;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        final ListNode listNode = reverseListRecursive(head.next);
        //head->4，这里扭转4和5的指针方向，并返回listNode(5->4)
        head.next.next = head;
        head.next = null;
        return listNode;
    }


    public static void main(String[] args) {
        final ListNode r = new ReverseList().reverseList(Ut.buildListNode(1, 2, 3, 4, 5));
        Ut.printListNode(r);
        final ListNode r2 = new ReverseList().reverseListRecursive(Ut.buildListNode(1, 2, 3, 4, 5));
        Ut.printListNode(r2);
    }
}
