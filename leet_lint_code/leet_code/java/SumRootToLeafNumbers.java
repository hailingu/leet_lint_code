// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 129.
// Date: 2019.8.14


class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        sumNumbers(root, list, 0);
        int ans = 0;
        for (int i : list) {
            ans += i;
        }
        return ans;
    }
    
    void sumNumbers(TreeNode root, List<Integer> list, int curr) {
        if (root == null) {
            return ;
        }
        
        curr = curr * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            list.add(curr);
        } else {
            sumNumbers(root.left, list, curr);
            sumNumbers(root.right, list, curr);
        }
    }
}