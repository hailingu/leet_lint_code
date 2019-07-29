// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 206.
// Date: 2019.7.5

import java.util.List;
import java.util.ArrayList;

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

    ListNode reverseList2(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        reverseHelp(list, 0, list.size() - 1);
        head = list.get(0);
        cur = head;
        for (ListNode node : list) {
            if (node != cur) {
                cur.next = node;
                cur = cur.next;
            }
        }
        cur.next = null;
        return head;
    }

    void reverseHelp(List<ListNode> list, int from, int to) {
        while (from < to) {
            ListNode tmp = list.get(from);
            list.set(from ++, list.get(to));
            list.set(to --, tmp);
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}