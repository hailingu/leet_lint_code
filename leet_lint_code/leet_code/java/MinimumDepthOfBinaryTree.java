// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 111.
// Date: 2019.8.14

class MinimumDepthOfBinaryTree {
    
    public int minDepth(TreeNode root) {
        return minDepth(root, 0);
    }
    
    int minDepth(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        
        if (root.left == null && root.right == null) {
            return level + 1;
        } else if (root.left != null && root.right == null) {
            return minDepth(root.left, level + 1);
        } else if (root.left == null && root.right != null) {
            return minDepth(root.right, level + 1);
        } else {
            return Math.min(minDepth(root.right, level + 1), minDepth(root.left, level + 1));
        }
    }
}