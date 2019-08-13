// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 203.
// Date: 2019.8.13

import java.util.List;
import java.util.ArrayList;

class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        List<ListNode> list = new ArrayList<>();
        
        ListNode iter = head;
        while (iter != null) {
            if (iter.val != val) {
                list.add(iter);
            }
            
            iter = iter.next;
        }
        
        head = null;
        if (list.size() > 0) {
            head = list.get(0);
            iter = head;
            int i = 1;
            while (i < list.size()) {
                iter.next = list.get(i);
                iter = iter.next;
                ++ i;
            }
            iter.next = null;
        }
    
        
        return head;
    }
}