// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 561.
// Date: 2019.7.29


import java.util.Arrays;

class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int ans = 0;
        for (int i = 0; i < nums.length / 2; ++ i) {
            ans += nums[i*2];
        }
        
        return ans;
    }
}