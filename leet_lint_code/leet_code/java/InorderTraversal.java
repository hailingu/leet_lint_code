// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 94.
// Date: 2019.7.4

import java.util.List;
import java.util.ArrayList;

public class InorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    private List<Integer> list = new ArrayList<>();

    List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalHelp(root);
        return list;
    }

    void inorderTraversalHelp(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}
