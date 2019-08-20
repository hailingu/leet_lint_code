// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 322.
// Date: 2019.8.20

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        int ans = coinChange(coins, amount, dp);
        return ans;
    }

    int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }

        if (dp[amount] != 0) {
            return dp[amount];
        }

        dp[amount] = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin == amount) {
                dp[amount] = 1;
                return dp[amount];
            } else {
                int ans = coinChange(coins, amount - coin, dp);
                if (ans != -1) {
                    dp[amount] = Math.min(dp[amount], ans + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            dp[amount] = -1;
        }

        return dp[amount];
    }
}