// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 61.
// Date: 2019.7.26

class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        ListNode i1 = head;
        int l = 1;
        
        while (i1.next != null) {
            i1 = i1.next;
            ++ l;
        }
        
        k = k % l;
        
        if (k == 0) {
            return head;
        }
    
        i1.next = head;
        ListNode tail = i1;
        i1 = head;
        int i = 0;
        
        k = l - k;

        while (i < k) {
            head = head.next;
            tail = tail.next;
            i ++;
        }
        
        tail.next = null;        
        return head;
    }
}