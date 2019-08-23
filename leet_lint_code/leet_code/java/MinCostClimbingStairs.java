// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 746.
// Date: 2019.8.23


class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        minCostClimbingStairs(cost, cost.length, dp);
        return dp[cost.length];
    }
    
    int minCostClimbingStairs(int[] cost, int i, int[] dp) {
        if (i < 2) {
            return 0;
        }
         
        if (dp[i] != 0) {
            return dp[i];
        }
        
        dp[i] = Math.min(minCostClimbingStairs(cost, i - 1, dp) + cost[i - 1], minCostClimbingStairs(cost, i - 2, dp) + cost[i - 2]);
        return dp[i];
    }
}