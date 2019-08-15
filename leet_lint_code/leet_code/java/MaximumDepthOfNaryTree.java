// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 559.
// Date: 2019.8.14

class MaximumDepthOfNaryTree {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        return maxDepth(root, 1);
    }
    
    int maxDepth(Node root, int level) {
        if (root == null) {
            return level;
        }
        
        int ans = level;
        for (Node node : root.children) {
            ans = Math.max(ans, maxDepth(node, level + 1));
        }
        return ans;
    }
}