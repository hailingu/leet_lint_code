// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 257.
// Date: 2019.9.9


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, ans, new StringBuilder());
        return ans;
    }

    void dfs(TreeNode root, List<String> ans, StringBuilder tmp) {
        if (root == null) {
            return;
        }

        tmp.append(root.val);

        if (root.left == null && root.right == null) {
            ans.add(tmp.toString());
        }

        dfs(root.left, ans, new StringBuilder(tmp));
        dfs(root.right, ans, new StringBuilder(tmp));
    }
}
