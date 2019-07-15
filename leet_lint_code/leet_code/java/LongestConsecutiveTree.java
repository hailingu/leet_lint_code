// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 289.
// Date: 2019.7.15

class LongestConsecutive {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return longestConsecutiveHelp(root, 1);
    }

    
    public int longestConsecutiveHelp(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        
        int leftVal = val;
        int rightVal = val;
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                leftVal = longestConsecutiveHelp(root.left, val + 1);
            } else {
                leftVal = longestConsecutiveHelp(root.left, 1);
            }
        }
        
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                rightVal = longestConsecutiveHelp(root.right, val + 1);
            } else {
                rightVal = longestConsecutiveHelp(root.right, 1);
            }
        }
                
        leftVal = Math.max(leftVal, rightVal);
        return Math.max(leftVal, val);
    }
}