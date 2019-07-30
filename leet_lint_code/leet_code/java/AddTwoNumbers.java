// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 2.
// Date: 2019.7.19

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i1 = l1;
        ListNode i2 = l2;
        
        ListNode ans = new ListNode(-1);
        ListNode ansIter = ans;

        int carrier = 0;
        while (i1 != null && i2 != null) {
            i1.val = i1.val + i2.val + carrier;
            carrier = i1.val / 10;
            i1.val = i1.val % 10;
            ansIter.next = i1;
            i1 = i1.next;
            i2 = i2.next;
            ansIter = ansIter.next;
        }
        
        if (i1 == null && i2 != null) {
            ansIter.next = i2;
            while (i2 != null && carrier > 0) {
                i2.val = i2.val + carrier;
                carrier = i2.val / 10;
                i2.val = i2.val % 10;
                ansIter.next = i2;
                i2 = i2.next;
                ansIter = ansIter.next;
            }
        }
        
        if (i1 != null && i2 == null) {
            ansIter.next = i1;
            while (i1 != null && carrier > 0) {
                i1.val = i1.val + carrier;
                carrier = i1.val / 10;
                i1.val = i1.val % 10;
                ansIter.next = i1;
                i1 = i1.next;
                ansIter = ansIter.next;  
            }
        }

        if (carrier > 0) {
            ansIter.next = new ListNode(1);
        }

        return ans.next;
    }
}