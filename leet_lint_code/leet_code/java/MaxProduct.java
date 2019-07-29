// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 152.
// Date: 2019.7.16

import java.util.HashMap;
import java.util.Map;


class MaxProduct {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int ans = nums[0];
        int min = nums[0];
        
        for (int i = 1; i < nums.length; ++ i) {
            min = Math.min(1, min) * nums[i];
            max = Math.max(1, max) * nums[i];
            
            if (min > max) {
                int temp = max;
                max = min;
                min = temp;
            }
            
            ans = Math.max(ans, max);
            ans = Math.max(ans, min);
        }
        return ans;
    }
}