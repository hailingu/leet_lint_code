// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 654.
// Date: 2019.7.29


class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeHelp(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTreeHelp(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        
        int i = left;
        int max = nums[left];
        int maxIdx = i;
        while (i <= right) {
            if (max < nums[i]) {
                maxIdx = i;
                max = nums[i];
            }
            ++ i;
        }
        
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTreeHelp(nums, left, maxIdx - 1);
        node.right = constructMaximumBinaryTreeHelp(nums, maxIdx + 1, right);
        return node;
    }
}    