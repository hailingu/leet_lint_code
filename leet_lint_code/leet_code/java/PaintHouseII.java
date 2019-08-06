// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 265.
// Date: 2019.8.7

public class PaintHouseII {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        int[][] memo = new int[n + 1][costs[0].length];
        return  minCost(costs,-1, 0, memo);
    }

    int minCost(int[][] costs, int last, int i, int[][] memo) {
        if (i >= costs.length) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < costs[0].length; ++j) {
            if (j != last) {
                if (memo[i + 1][j] == 0) {
                    memo[i + 1][j] = minCost(costs, j, i + 1, memo);
                }
                ans = Math.min(ans, memo[i + 1][j] + costs[i][j]);
            }
        }
        return ans;
    }
}