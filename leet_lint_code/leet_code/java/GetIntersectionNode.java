// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 160.
// Date: 2019.7.19

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=  new HashSet<>();
        ListNode iter = headA;
        while (iter != null) {
            set.add(iter);
            iter = iter.next;
        }
        
        iter = headB;
        while (iter != null) {
            if (set.contains(iter)) {
                return iter;
            }
            iter = iter.next;
        }
        
        return null;
    }
}