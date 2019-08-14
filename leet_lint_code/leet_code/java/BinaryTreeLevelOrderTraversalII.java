// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 103.
// Date: 2019.8.14

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (root == null) {
            return ans;
        }

        // 0. left to right 1. right to left
        int order = 0;
        stack2.push(root);
        while (!stack2.isEmpty()) {
            ans.add(levelOrder(stack1, stack2, order));
            stack2.addAll(stack1);
            stack1.clear();
            order++;
            order %= 2;
        }

        return ans;
    }

    List<Integer> levelOrder(Stack<TreeNode> stack1, Stack<TreeNode> stack2, int order) {
        List<Integer> levelAns = new ArrayList<>();
        if (order == 0) {
            while (!stack2.isEmpty()) {
                TreeNode top = stack2.pop();
                if (top.left != null) {
                    stack1.push(top.left);
                }

                if (top.right != null) {
                    stack1.push(top.right);
                }

                levelAns.add(top.val);
            }
        } else {
            while (!stack2.isEmpty()) {
                TreeNode top = stack2.pop();
                if (top.right != null) {
                    stack1.push(top.right);
                }

                if (top.left != null) {
                    stack1.push(top.left);
                }

                levelAns.add(top.val);
            }
        }

        stack2.clear();
        return levelAns;
    }
}
