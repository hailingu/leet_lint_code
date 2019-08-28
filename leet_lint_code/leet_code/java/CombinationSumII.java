// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 40.
// Date: 2019.8.27

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, ans, list, 0, 0);
        return ans;
    }

    void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> curr, int sum, int idx) {
        if (target == sum) {
            ans.add(curr);
        }
        int i = idx;
        while (i < candidates.length) {
            int sum2 = sum + candidates[i];
            if (sum2 <= target) {
                if ((curr.size() > 0 && candidates[i] >= curr.get(curr.size() - 1)) || curr.size() == 0 ) {
                    List<Integer> back = new ArrayList<>(curr);
                    back.add(candidates[i]);
                    backtrack(candidates, target, ans, back, sum2, i + 1);
                }
            }

            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) ++ i;
            ++ i;
        }
    }
}
