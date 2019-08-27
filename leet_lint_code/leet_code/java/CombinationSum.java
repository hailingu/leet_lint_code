// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 39.
// Date: 2019.8.27

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;


class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<Integer> set = new HashSet<>();
        for (int candidate : candidates) {
            set.add(candidate);
        }
        
        Iterator<Integer> iter = set.iterator();
        candidates = new int[set.size()];
        int idx = 0;
        while (iter.hasNext()) {
            candidates[idx ++] = iter.next();
        }
        
        Arrays.sort(candidates);
        
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, ans, list, 0);
        return ans;
    }
    
    void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> curr, int sum) {
        if (target == sum) {
            ans.add(curr);
        }
        
        for (int i = 0; i < candidates.length; ++ i) {
            int sum2 = sum + candidates[i];
            if (sum2 <= target) {
                if ((curr.size() > 0 && candidates[i] >= curr.get(curr.size() - 1)) || curr.size() == 0 ) {
                    List<Integer> back = new ArrayList<>(curr);
                    back.add(candidates[i]);
                    backtrack(candidates, target, ans, back, sum2);
                } 
            }
        }
    }
}