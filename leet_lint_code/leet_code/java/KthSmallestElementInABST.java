// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 230.
// Date: 2019.8.9

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> preOrder = new ArrayList<>();
        preOrder(root, preOrder, k);
        return preOrder.get(k - 1);
    }

    void preOrder(TreeNode root, List<Integer> list, int k) {
        if (root == null) {
            return ;
        }

        preOrder(root.left, list, k);
        list.add(root.val);
        if (list.size() == k) {
            return ;
        }
        preOrder(root.right, list, k);
    }
}