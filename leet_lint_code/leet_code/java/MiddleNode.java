// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 876.
// Date: 2019.7.8

class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null) {
            if (fast.next == null) {
                break;
            } else {
                fast = fast.next.next;
            }
            slow = slow.next;
        }
        return slow;
    }
}