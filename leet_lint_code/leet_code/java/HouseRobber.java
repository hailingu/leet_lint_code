// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 198.
// Date: 2019.8.20


class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++ i) {
            if (i == 0 || i == 1) {
                dp[i] = nums[i];
            } else {
                int max = dp[i -2];
                if (i - 3 >= 0) {
                    max = Math.max(max, dp[i-3]);
                }
                dp[i] += max + nums[i];
            }
        }
        
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}