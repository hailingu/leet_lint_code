// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 98.
// Date: 2019.7.7

public class ValidateBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelp(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBSTHelp(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }

        return root.val > lower && root.val < upper
                && isValidBSTHelp(root.left, lower, root.val) && isValidBSTHelp(root.right, root.val, upper);
    }
}
