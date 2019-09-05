// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1034.
// Date: 2019.9.5


public class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        if (m == 0 || n == 0) {
            return grid;
        }

        int target = grid[r0][c0];
        dfs(grid, r0, c0, target);
        maskBorder(grid, r0, c0);

        for (int i = 0; i < grid.length; ++ i) {
            for (int j = 0; j < grid[0].length; ++ j) {
                if (grid[i][j] == -2) grid[i][j] = target;
                if (grid[i][j] == -3) grid[i][j] = color;
            }
        }

        return grid;
    }

    void dfs(int[][] grid, int i, int j, int target) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != target) {
            return;
        }

        grid[i][j] = -1;
        dfs(grid, i + 1, j, target);
        dfs(grid, i - 1, j, target);
        dfs(grid, i, j - 1, target);
        dfs(grid, i, j + 1, target);
    }

    void maskBorder(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != -1) {
            return;
        }

        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            grid[i][j] = -3;
        } else if (!((grid[i - 1][j] == -1 || grid[i - 1][j] == -3 || grid[i - 1][j] == -2) &&
                (grid[i + 1][j] == -1 || grid[i + 1][j] == -3 || grid[i + 1][j] == -2) &&
                (grid[i][j + 1] == -1 || grid[i][j + 1] == -3 || grid[i][j + 1] == -2) &&
                (grid[i][j - 1] == -1 || grid[i][j - 1] == -3 || grid[i][j - 1] == -2))) {
            grid[i][j] = -3;
        } else {
            grid[i][j] = -2;
        }

        maskBorder(grid, i + 1, j);
        maskBorder(grid, i - 1, j);
        maskBorder(grid, i, j + 1);
        maskBorder(grid, i, j - 1);
    }
}
