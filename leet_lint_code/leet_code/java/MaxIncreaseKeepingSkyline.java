// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 844.

public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int [][] minGrid = new int[grid.length][grid[0].length];
        int sum0 = 0;
        int sum1 = 0;

        for (int m = 0; m < grid.length; ++ m) {
            int minMax = grid[m][0];
            for (int n = 0; n < grid[0].length; ++ n) {
                minMax = Math.max(minMax, grid[m][n]);
                sum0 += grid[m][n];
            }

            for (int n = 0; n < grid[0].length; ++ n) {
                minGrid[m][n] = minMax;
            }
            sum1 += minMax * grid[0].length;
        }

        for (int m = 0; m < grid[0].length; ++ m) {
            int minMax = grid[0][m];
            for (int[] ints : grid) {
                minMax = Math.max(minMax, ints[m]);
            }

            for (int n = 0; n < grid.length; ++ n) {
                if (minMax < minGrid[n][m]) {
                    sum1 += minMax - minGrid[n][m];
                }
            }
        }

        return sum1 - sum0;
    }
}
