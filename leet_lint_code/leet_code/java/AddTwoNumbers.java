
// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 2.
// Date: 2019.7.19


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> l1List = new ArrayList<>();
        List<ListNode> l2List = new ArrayList<>();
        
        ListNode iter = l1;
        while (iter != null) {
            l1List.add(iter);
            iter = iter.next;
        }
        
        iter = l2;
        while (iter != null) {
            l2List.add(iter);
            iter = iter.next;
        }
        
        if (l1List.size() < l2List.size()) {
            List<ListNode> t = l1List;
            l1List = l2List;
            l2List = t;
        }
        
        int i = 0;
        int sum = 0;
        int carrier = 0;
        for (; i < l2List.size(); ++ i) {
            sum = l1List.get(i).val + l2List.get(i).val + carrier;
            carrier = sum / 10;
            l1List.get(i).val = sum % 10;
        }
        
        while (carrier > 0 && i < l1List.size()) {
            sum = l1List.get(i).val + carrier;
            carrier = sum / 10;
            l1List.get(i).val = sum % 10;
            ++ i;
        }
        
        if (carrier > 0) {
            l1List.add(new ListNode(1));
        }
        
        ListNode ans = l1List.get(0);
        iter = ans;
        for (int q = 1; q < l1List.size(); ++ q) {
            iter.next = l1List.get(q);
            iter = iter.next;
        }
        
        return ans;
    }
}