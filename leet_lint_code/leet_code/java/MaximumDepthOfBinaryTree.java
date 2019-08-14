// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 104.
// Date: 2019.8.14


class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    
    int maxDepth(TreeNode root, int level) {
        if (root == null) {
            return level;
        }
        
        return Math.max(maxDepth(root.left, level + 1), maxDepth(root.right, level + 1));
    }
}