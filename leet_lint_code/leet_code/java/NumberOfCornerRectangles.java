// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 750.
// Date: 2019.8.5

public class NumberofCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m - 1; ++i) {
            for (int j = i + 1; j < m; ++j) {
                int cnt = 0;
                for (int q = 0; q < n; ++q) {
                    if (grid[i][q] == 1 && grid[j][q] == 1) {
                        cnt++;
                    }
                }
                ans += cnt * (cnt - 1) / 2;
            }


        }

        return ans;
    }
}