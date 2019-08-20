// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: leet code
// This is a answer of leet code problem 279.
// Date: 2019.8.21


class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++ i) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; ++ j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}