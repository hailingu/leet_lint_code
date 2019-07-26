// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 19.
// Date: 2019.7.27

class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode curr = head;
        ListNode tail = head;
        
        int i = 0;
        while (i < n) {
            ++ i;
            tail = tail.next;
        }
        
        if (tail == null) {
            return head.next;
        }
        
        curr = curr.next;
        
        while (tail.next != null) {
            tail = tail.next;
            curr = curr.next;
            prev = prev.next;
        }
        
        prev.next = curr.next;
        
        return head;
    }
}