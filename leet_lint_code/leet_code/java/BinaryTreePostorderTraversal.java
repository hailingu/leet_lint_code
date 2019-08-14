// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 145.
// Date: 2019.8.14


class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
        postorderTraversal(root, ans);
        return ans;
    }
    
    void postorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return ;
        }
        
        postorderTraversal(root.left, ans);
        postorderTraversal(root.right, ans);
        ans.add(root.val);
    }
}