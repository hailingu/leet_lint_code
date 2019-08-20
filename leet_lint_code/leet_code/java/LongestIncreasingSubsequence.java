// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 300.
// Date: 2019.8.21

class  LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return 1;
        }
        
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++ i) {
            dp[i] = 1;
            int j = i - 1;
            int dpt = 0;
            while(j >= 0) {
                if (nums[j] < nums[i]) {
                    dpt = Math.max(dpt, dp[j]);
                }
                
                -- j;
                
            }
            
            dp[i] = dpt + 1;
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}