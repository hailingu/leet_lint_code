// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 64.
// Date: 2019.8.4

class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        backtrack(grid, ans, grid.length - 1, grid[0].length -1);
        return ans[grid.length - 1][grid[0].length - 1];
    }
    
    int backtrack(int[][] grid, int[][] ans, int i, int j) {
        if (i == 0 && j == 0) {
            ans[0][0] = grid[0][0];
            return ans[0][0];
        }
        
        if (ans[i][j] != 0) {
            return ans[i][j];
        }
        
        if (i == 0 && j != 0) {
            ans[0][j] = grid[i][j] + backtrack(grid, ans, i, j - 1);
            return ans[0][j];
        }
        
        if (i != 0 && j == 0) {
            ans[i][0] = grid[i][j] + backtrack(grid, ans, i - 1, j);
            return ans[i][0];
        }
        
        ans[i][j] = grid[i][j] + Math.min(backtrack(grid, ans, i - 1, j), backtrack(grid, ans, i, j-1));
        return ans[i][j];
    }
}