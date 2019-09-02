// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 199.
// Date: 2019.9.2

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightSideView(root, 0, ans);
        return ans;
    }
    List<Integer> rightSideView(TreeNode root, int level, List<Integer> ans) {
        if (root == null) {
            return ans;
        }

        if (level >= ans.size()) {
            ans.add(root.val);
        } else {
            ans.set(level, root.val);
        }

        rightSideView(root.left, level + 1, ans);
        rightSideView(root.right, level+ 1, ans);

        return ans;
    }

}
