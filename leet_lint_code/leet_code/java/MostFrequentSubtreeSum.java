// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 508.
// Date: 2019.8.19

import java.util.*;

public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        int[] ans = null;
        Map<TreeNode, Integer> memo = new HashMap<>();
        Map<Integer, Integer> reverseMemo = new HashMap<>();
        findFrequentTreeSum(root, memo, reverseMemo);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(reverseMemo.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -(o1.getValue()).compareTo(o2.getValue());
            }
        });

        List<Integer> tmpAns = new ArrayList<>();
        int topCnt = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); ++ i) {
            int cnt = list.get(i).getValue();
            if (topCnt < cnt) {
                topCnt = cnt;
                tmpAns.add(list.get(i).getKey());
            } else if (cnt == topCnt) {
                tmpAns.add(list.get(i).getKey());
            } else {
                break;
            }
        }

        ans = new int[tmpAns.size()];
        for (int i = 0; i < tmpAns.size(); ++ i) {
            ans[i] = tmpAns.get(i);
        }
        return ans;
    }

    int findFrequentTreeSum(TreeNode root, Map<TreeNode, Integer> memo, Map<Integer, Integer> reverseMemo) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int sum = root.val + findFrequentTreeSum(root.left, memo, reverseMemo) + findFrequentTreeSum(root.right, memo, reverseMemo);
        memo.put(root, sum);
        if (reverseMemo.containsKey(sum)) {
            reverseMemo.put(sum, reverseMemo.get(sum) + 1);
        } else {
            reverseMemo.put(sum, 1);
        }
        return sum;
    }
}
