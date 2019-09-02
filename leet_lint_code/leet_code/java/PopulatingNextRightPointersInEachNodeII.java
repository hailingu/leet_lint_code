// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 117.
// Date: 2019.9.1

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        Node iter = root.next;
        while (iter != null && iter.left == null && iter.right == null) {
            iter = iter.next;
        }

        if (iter != null) {
            if (root.right != null) {
                root.right.next = iter.left != null ? iter.left : iter.right;
            } else if (root.left != null){
                root.left.next = iter.left != null ? iter.left : iter.right;
            }
        }

        connect(root.right);
        connect(root.left);
        return root;
    }
}