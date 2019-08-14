// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 100.
// Date: 2019.8.14

class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q == null) {
            return false;
        } else if (p == null && q != null) {
            return false;
        } else if (p == null && q == null) {
            return true;
        } else {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}