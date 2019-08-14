// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 112.
// Date: 2019.8.14

class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        return hasPathSum(root, 0, sum);
    }
    
     boolean hasPathSum(TreeNode root, int sum, int target) {
         if (root == null) {
            return false;
         }   
         
         sum += root.val;
         if (sum == target && root.left == null && root.right == null) {
             return true;
         }
                            
         return hasPathSum(root.left, sum, target) || hasPathSum(root.right, sum, target);
     }
}