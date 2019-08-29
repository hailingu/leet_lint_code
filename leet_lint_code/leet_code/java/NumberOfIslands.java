// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 200.
// Date: 2019.8.29

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int cnt = 0;
        
        for (int i = 0; i < grid.length; ++ i) {
            for (int j = 0; j < grid[0].length; ++ j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++ cnt;
                }
            }
        }

        return cnt;
    }

    void dfs(char[][] grid, int i, int j) {
        int r = grid.length;
        int c = grid[0].length;

        if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}