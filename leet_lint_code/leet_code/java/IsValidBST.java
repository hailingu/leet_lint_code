// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 98.
// Date: 2019.7.7

public class IsValidBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftIsValid = true;
        if (root.left != null) {
            leftIsValid = root.left.val < root.val && isValidBSTHelp(root.left, Long.MIN_VALUE, root.val);
        }

        boolean rightIsValid = true;
        if (root.right != null) {
            rightIsValid = root.right.val > root.val && isValidBSTHelp(root.right, root.val, Long.MAX_VALUE);
        }

        return leftIsValid && rightIsValid;
    }

    boolean isValidBSTHelp(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }

        return root.val > lower && root.val < upper
                && isValidBSTHelp(root.left, lower, root.val) && isValidBSTHelp(root.right, root.val, upper);
    }
}
