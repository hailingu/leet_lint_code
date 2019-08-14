// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 102.
// Date: 2019.8.14

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> stack1 = new LinkedList<>();
        Queue<TreeNode> stack2 = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
             List<Integer> levelAns = new ArrayList<>();

             if (stack1.isEmpty()) {
                 while (!stack2.isEmpty()) {
                     TreeNode head = stack2.poll();
                     if (head.left != null) {
                         stack1.add(head.left);
                     }

                     if (head.right != null) {
                         stack1.add(head.right);
                     }
                     levelAns.add(head.val);
                 }
             } else {
                 while (!stack1.isEmpty()) {
                     TreeNode head = stack1.poll();
                     if (head.left != null) {
                         stack2.add(head.left);
                     }

                     if (head.right != null) {
                         stack2.add(head.right);
                     }
                     levelAns.add(head.val);
                 }
             }
             ans.add(levelAns);
        }

        return ans;
    }
}
