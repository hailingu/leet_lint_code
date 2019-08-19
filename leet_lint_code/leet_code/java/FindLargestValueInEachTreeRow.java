// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 515.
// Date: 2019.8.19


import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
             int levelAns = Integer.MIN_VALUE;

             if (queue1.isEmpty()) {
                 while (!queue2.isEmpty()) {
                     TreeNode head = queue2.poll();
                     if (head.left != null) {
                         queue1.add(head.left);
                     }

                     if (head.right != null) {
                         queue1.add(head.right);
                     }
                     
                     levelAns = Math.max(levelAns, head.val);
                 }
             } else {
                 while (!queue1.isEmpty()) {
                     TreeNode head = queue1.poll();
                     if (head.left != null) {
                         queue2.add(head.left);
                     }

                     if (head.right != null) {
                         queue2.add(head.right);
                     }
                     levelAns = Math.max(levelAns, head.val);
                 }
             }
             ans.add(levelAns);
        }

        return ans;
    }
}