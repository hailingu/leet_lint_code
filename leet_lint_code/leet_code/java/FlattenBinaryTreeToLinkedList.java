// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 114.
// Date: 2019.8.28

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        List<TreeNode> list = new ArrayList<>();
        flattern(root, list);
        TreeNode dummy = new TreeNode(-1);
        TreeNode iter = dummy;
        for (TreeNode node : list) {
            iter.left = null;
            iter.right = node;
            iter = iter.right;
        }
        
        root = dummy.right;
    }
    
    void flattern(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return ;
        }
        
        list.add(root);
        flattern(root.left, list);
        flattern(root.right, list);
    }
}