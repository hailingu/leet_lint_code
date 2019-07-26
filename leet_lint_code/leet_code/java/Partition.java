// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 86.
// Date: 2019.7.27

class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        
        List<ListNode> lt = new ArrayList<>();
        List<ListNode> ge = new ArrayList<>();
        
        ListNode iter = head;
        while (iter != null) {
            if (iter.val < x) {
                lt.add(iter);
            } else {
                ge.add(iter);
            }
            
            iter = iter.next;
        }
        
        ListNode dummyHead = new ListNode(-1);
        iter = dummyHead;
        int i = 0;
        while (i < lt.size()) {
            iter.next = lt.get(i ++);
            iter = iter.next;
        }
        
        i = 0;
        while (i < ge.size()) {
            iter.next = ge.get(i ++);
            iter = iter.next;
        }
        
        iter.next = null;
        return dummyHead.next;
    }
}