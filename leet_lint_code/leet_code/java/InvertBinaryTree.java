// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 226.
// Date: 2019.8.13

class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode memo = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(memo);
     
        return root;
    }
}