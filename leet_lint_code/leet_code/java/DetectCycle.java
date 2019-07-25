// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 142.
// Date: 2019.7.25

public class DetectCycle {

    ListNode getIntersect(ListNode head) {
        ListNode i1 = head;
        ListNode i2 = head;

        while (i2 != null && i2.next != null) {
            i1 = i1.next;
            i2 = i2.next.next;

            if (i1 == i2) {
                return i1;
            }
        }

        return null;
    }

    ListNode detectCycle(ListNode head) {
        ListNode inter = getIntersect(head);

        if (inter == null) {
            return inter;
        }

        ListNode i1 = head;

        while (i1 != inter) {
            i1 = i1.next;
            inter = inter.next;
        }

        return i1;
    }
}