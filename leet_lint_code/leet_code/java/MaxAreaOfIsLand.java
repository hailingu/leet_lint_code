// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 695.
// Date: 2019.9.5

class MaxAreaOfIsLand {
    int square = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                square = 0;
                dfs(grid, i, j, m, n);
                ans = Math.max(ans, square);
            }
        }
        return ans;
    }
    
    void dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) {
            return ;
        }
        
        grid[i][j] = -1;
        ++ square;
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }
}