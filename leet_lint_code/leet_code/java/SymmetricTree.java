// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 101.
// Date: 2019.8.14

class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isSymmetric(root.left, root.right);
    }
    
    boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p != null && q == null) {
            return false;
        } else if (p == null && q != null) {
            return false;
        } else if (p == null && q == null) {
            return true;
        } else {
            return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        }
    }
}