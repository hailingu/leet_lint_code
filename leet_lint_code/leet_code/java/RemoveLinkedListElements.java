// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 203.
// Date: 2019.8.13


class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode iter = head;
        ListNode curr = dummyHead;
        
        while (iter != null) {
            if (iter.val != val) {
                iter = iter.next;
                curr = curr.next;
            } else {
                iter = iter.next;
                curr.next = iter;
            }
        }
        
        return dummyHead.next;
    }
}