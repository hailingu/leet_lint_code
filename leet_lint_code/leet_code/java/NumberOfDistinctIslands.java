// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 694.
// Date: 2019.9.5

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        if (m == 0 || n == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                List<Point> history = new ArrayList<>();
                dfs(grid, i, j, m, n, history);
                StringBuilder sb = new StringBuilder();

                history.remove(0);
                for (Point s : history) {
                    sb.append(s);
                }
                set.add(sb.toString());
            }
        }

        return set.size();
    }

    void dfs(int[][] grid, int i, int j, int m, int n, List<Point> history) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) {
            return;
        }

        if (history.size() == 0) {
            history.add(new Point(i, j));
        } else {
            Point origin = history.get(0);
            history.add(new Point(i - origin.x, j - origin.y));
        }

        grid[i][j] = -1;
        dfs(grid, i - 1, j, m, n, history);
        dfs(grid, i + 1, j, m, n, history);
        dfs(grid, i, j - 1, m, n, history);
        dfs(grid, i, j + 1, m, n, history);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return x + "" + y;
    }
}