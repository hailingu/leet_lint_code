// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 532 .
// Date: 2019.8.23


import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++ i) {
            for (int j = i + 1; j < nums.length && Math.abs(nums[i] - nums[j]) <= k; ++ j) {
                int val = nums[i] * 10 + nums[j];
                if (k == Math.abs(nums[i] - nums[j]) && !set.contains(val)) {
                    ++ ans;
                }
                
                set.add(val);
            }
            
        }
        
        return ans;
    }
}