// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 141.
// Date: 2019.7.19

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode fast = head.next.next;
        ListNode slow = head;
        
        while (fast != null) {
            if (fast == slow) {
                return true;
            }
            
            if (fast.next == null) {
                return false;
            } else {
                fast = fast.next.next;
            }
            
            slow = slow.next;
        }
        
        return false;
    }
}