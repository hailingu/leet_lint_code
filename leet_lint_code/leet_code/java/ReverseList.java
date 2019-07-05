// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 206.
// Date: 2019.7.5

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
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

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}