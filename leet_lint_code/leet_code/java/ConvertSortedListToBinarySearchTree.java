// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 109.
// Date: 2019.8.30


public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode prevPtr;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        prevPtr = dummy;

        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = prevPtr.next;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        prevPtr.next = null;
        TreeNode root = new TreeNode(slowPtr.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slowPtr.next);
        return root;
    }
}
