// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 542.
// Date: 2019.9.10


class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
      int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
      if (m == 0 || n == 0) {
          return matrix;
      }
        

      int[][] ans = new int[m][n];
      boolean[][] visited = new boolean[m][n];
        
      for (int i = 0; i < m; ++ i) {
          Arrays.fill(ans[i], 200000);
      }

      for (int i = 0; i < m; ++i) {
          for (int j = 0; j < n; ++j) {
              dfs(matrix, ans, visited, i, j, m, n, 1);
          }
      }

      visited = new boolean[m][n];
      for (int i = m - 1; i >= 0; --i) {
          for (int j = n - 1; j >= 0; --j) {
              dfs(matrix, ans, visited, i, j, m, n, 2);
          }
      }


      return ans;
  }


  int dfs(int[][] matrix, int[][] ans, boolean[][] visited, int i, int j, int m, int n, int direction) {
      if (i < 0 || j < 0 || i >= m || j >= n) {
          return 200000;
      }

      if (visited[i][j]) {
          return ans[i][j];
      }

      if (matrix[i][j] == 0) {
          ans[i][j] = 0;
      } else {
          if (direction == 1) {
              int t = Math.min(dfs(matrix, ans, visited, i + 1, j, m, n, direction),
                      dfs(matrix, ans, visited, i, j + 1, m, n, direction)) + 1;
              ans[i][j] = Math.min(t, ans[i][j]);
          } else {
              int t = Math.min(dfs(matrix, ans, visited, i - 1, j, m, n, direction),
                      dfs(matrix, ans, visited, i, j - 1, m, n, direction)) + 1;
              ans[i][j] = Math.min(t, ans[i][j]);
          }
      }

      visited[i][j] = true;
      return ans[i][j];
  }
}