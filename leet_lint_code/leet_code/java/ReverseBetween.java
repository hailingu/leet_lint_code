// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 92.
// Date: 2019.7.7

class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode reverseHead = dummyHead;
        for (int i = 0; i < m - 1; ++ i) {
            reverseHead = reverseHead.next;
        }

        ListNode pre = reverseHead;
        reverseHead = reverseHead.next;
        ListNode cur = reverseHead.next;
        ListNode tmp;

        int i = 0;
        int l = n - m;
        while (i < l) {
            tmp = pre.next;
            pre.next = cur;
            reverseHead.next = cur.next;
            cur.next = tmp;
            cur = reverseHead.next;
            ++ i;
        }

        return dummyHead.next;
    }
}