// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 222.
// Date: 2019.7.27


class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}