package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

/**
 * @author chenshengbin
 * @date 2022/1/7 14:52
 */
public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        //原理：t= head.length%k,链表长度 head.length/k + t?1 (t--) : 0
        //计算长度
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        int mod = len % k;
        int divide = len / k;

        //遍历数
        final ListNode[] res = new ListNode[k];
        int tk = 0;
        ListNode hh = null;
        int cnt = 0;
        while (head != null) {
            //TODO
            if (cnt < divide + (mod > 0 ? 1 : 0)) {
                if (cnt == 0) {
                    hh = new ListNode(head.val);
                } else {
                    hh.next = new ListNode(head.val);
                }
                cnt++;
            } else {

            }
        }
        return res;
    }

    public static void main(String[] args) {
        Ut.printListNode(new SplitListToParts().splitListToParts(Ut.buildListNode(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3));
    }
}
