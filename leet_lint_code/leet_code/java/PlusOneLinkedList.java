// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 369.
// Date: 2019.7.17


class PlusOneLinkedList {


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode plusOne(ListNode head) {
        head = reverseList(head);
        
        int carrier = 0;
        ListNode iter = head;
        int sum = iter.val + 1;
        carrier = sum / 10;
        iter.val = sum % 10;
        ListNode tail = head;
        
        iter = iter.next;
        while (iter != null && carrier > 0) {
            sum = iter.val + carrier;
            carrier = sum / 10;
            iter.val = sum % 10;
            if (iter.next == null) {
                tail = iter;
            }
            iter = iter.next;
            
        }
        
        if (carrier > 0) {
            tail.next = new ListNode(carrier);
        }
        
        head = reverseList(head);
        return head;
    }
    
    ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode iter = head.next;
        head.next = null;
        ListNode tmp;

        while (iter != null) {
            tmp = iter.next;
            iter.next = head;
            head = iter;
            iter = tmp;
        }

        return head;
    }
}