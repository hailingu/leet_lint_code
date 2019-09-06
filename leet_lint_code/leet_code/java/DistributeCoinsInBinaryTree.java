// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 979.
// Date: 2019.9.6

class DistributeCoinsInBinaryTree {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int L = dfs(root.left);
        int R = dfs(root.right);
        ans += Math.abs(L) + Math.abs(R);
        return root.val + L + R - 1;
    } 
}  