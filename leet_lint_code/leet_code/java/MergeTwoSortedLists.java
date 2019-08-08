// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 21.
// Date: 2019.8.8

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode iter = null;
        ListNode head = null;

        if (l1.val < l2.val) {
            iter = head = l1;
            l1 = l1.next;
        } else {
            iter = head = l2;
            l2 = l2.next;
        }

        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }

        if (null != l1) iter.next = l1;
        if (null != l2) iter.next = l2;
        return head;
    }
}

// LEETLINTCODE_LINTCODE_MERGETWOSORTEDLISTS_JAVA
