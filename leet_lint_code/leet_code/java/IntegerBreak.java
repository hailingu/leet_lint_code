// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 343.
// Date: 2019.8.21

import java.util.Arrays;

class IntegerBreak {
    public int integerBreak(int n) {
        
        int[] dp = new int[n + 1];
        for (int i = 1;  i <= n; ++ i) {
            dp[i] = 1;
            for (int j = 1; j < i;  ++ j) {
                dp[i] = Math.max(dp[i], dp[i - j] * j);
                dp[i] = Math.max(dp[i], (i - j) * j);
            }
        }
        return dp[n];
    }
}