// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 113.
// Date: 2019.8.14

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        pathSum(root, 0, sum, init, ans);
        return ans;
    }
    
    void pathSum(TreeNode root, int sum, int target, List<Integer> list, List<List<Integer>> ans) {
        if (root == null) {
            return ;
        }
        
        sum += root.val;
        list.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            ans.add(list);
            return ;
        }
        
        List<Integer> left = new ArrayList(list);
        pathSum(root.left, sum, target, left, ans);
        List<Integer> right = new ArrayList(list);
        pathSum(root.right, sum, target, right, ans);
    }
}