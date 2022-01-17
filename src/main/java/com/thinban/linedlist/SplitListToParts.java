package com.thinban.linedlist;

import com.thinban.base.ListNode;
import com.thinban.base.Ut;

/**
 * @author chenshengbin
 * @date 2022/1/7 14:52
 */
public class SplitListToParts {
    /**
     * 100.00%,0 ms
     * 67.18%,38.5 MB
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        //原理：t= head.length%k,链表长度 head.length/k + t?1 (t--) : 0
        //1.计算mod和divide
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        int mod = len % k;
        int divide = len / k;

        //2.构造或链接子链表
        final ListNode[] res = new ListNode[k];
        int idx = 0;
        ListNode hh = null;
        ListNode tt = null;
        int cnt = 0;
        while (head != null) {
            int subLen = divide + (mod > 0 ? 1 : 0);
            //妙啊：“计划加入”，先完成计算
            cnt++;
            if (cnt == 1) {
                tt = hh = new ListNode(head.val);
                res[idx] = tt;
            } else {
                //add
                hh.next = new ListNode(head.val);
                hh = hh.next;
            }
            if (cnt == subLen) {
                cnt = 0;
                idx += 1;
                if (subLen != divide) {
                    mod--;
                }
            }
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Ut.printListNode(new SplitListToParts().splitListToParts(Ut.buildListNode(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3));
        Ut.printListNode(new SplitListToParts().splitListToParts(Ut.buildListNode(1, 2, 3), 5));
    }
}
