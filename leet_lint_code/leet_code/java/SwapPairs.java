// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 24.
// Date: 2019.8.11

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode a = head;
        ListNode b = head.next;
        ListNode c = dummyHead;
        
        while (a != null && b != null) {
            a.next = b.next;
            c.next = b;
            b.next = a;
            
            c = a;
            a = a.next;
            
            if (a == null) {
                break;
            }
            b = a.next;
        }
        
        return dummyHead.next;
    }
}