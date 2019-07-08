// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 94.
// Date: 2019.7.4

public class InorderTraversal {

    private List<Integer> l = new ArrayList<>();

    List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalHelp(root);
        return l;
    }

    void inorderTraversalHelp(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        l.add(root.val);
        inorderTraversal(root.right);
    }
}
