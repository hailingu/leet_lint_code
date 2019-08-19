// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 124.
// Date: 2019.8.19


import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Map<TreeNode, Integer> memo = new HashMap<>();
        Map<TreeNode, Integer> memoSingle = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        maxPathSumAll(root, memo, memoSingle);
        for (Map.Entry<TreeNode, Integer> entry : memo.entrySet()) {
            ans = Math.max(ans, entry.getValue());
        }

        for (Map.Entry<TreeNode, Integer> entry : memoSingle.entrySet()) {
            ans = Math.max(ans, entry.getValue());
        }

        return ans;
    }

    int maxPathSumAll(TreeNode root, Map<TreeNode, Integer> memo, Map<TreeNode, Integer> memoSingle) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int sum = root.val;
        int left = maxPathSumSingle(root.left, memoSingle);
        int right = maxPathSumSingle(root.right, memoSingle);
        sum = sum + Math.max(0, left) + Math.max(0, right);
        memo.put(root, sum);

        maxPathSumAll(root.left, memo, memoSingle);
        maxPathSumAll(root.right, memo, memoSingle);

        return sum;
    }

    int maxPathSumSingle(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int sum = root.val;
        int left = maxPathSumSingle(root.left, memo);
        int right = maxPathSumSingle(root.right, memo);

        sum = Math.max(sum + Math.max(0, left), sum + Math.max(0, right));
        memo.put(root, sum);
        return sum;
    }
}
