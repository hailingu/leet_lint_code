// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 661.
// Date: 2019.8.23

class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length, n = m > 0 ? M[0].length : 0;
        int[][] ans = new int[m][n];
          
        Idx mIdx = new Idx(0, 0, m, n);
        Idx ansIdx = new Idx(0, 0, m, n);
        
        while (!mIdx.isEnd() && !ansIdx.isEnd()) {
            int sum = 0;
            int cnt = 0;
            
            int x, y;
            // top
            x = mIdx.x - 1;
            y = mIdx.y;
            
            if (x >= 0) {
                sum += M[x][y];
                ++ cnt;
            }
            
            // down
            x = mIdx.x + 1;
            y = mIdx.y;

            if (x < m) {
                sum += M[x][y];
                ++ cnt;
            }

            // left
            x = mIdx.x;
            y = mIdx.y - 1;

            if (y >= 0) {
                sum += M[x][y];
                ++ cnt;
            }

              // right
              x = mIdx.x;
              y = mIdx.y + 1;

              if (y < n) {
                sum += M[x][y];
                ++ cnt;
              }

              // left top
              x = mIdx.x - 1;
              y = mIdx.y - 1;
              if (x >= 0 && y >= 0) {
                    sum += M[x][y];
                ++ cnt;
              }

              // right top
              x = mIdx.x - 1;
              y = mIdx.y + 1;
              if (x >= 0 && y < n) {
                    sum += M[x][y];
                ++ cnt;
              }      

              // left down
              x = mIdx.x + 1;
              y = mIdx.y - 1;
              if (x < m && y >= 0) {
                    sum += M[x][y];
                ++ cnt;
              }

              // right down
              x = mIdx.x + 1;
              y = mIdx.y + 1;
              if (x < m && y < n) {
                sum += M[x][y];
                ++ cnt;
              }
            
          sum += M[mIdx.x][mIdx.y];
          ++ cnt;
          ans[ansIdx.x][ansIdx.y] = sum / cnt;
          mIdx.next();
          ansIdx.next();
        }
      
        return ans;
    }
}

class Idx {
  int x;
  int y;
  
  int m;
  int n;
  
  Idx(int x, int y, int m, int n) {
    this.x = x;
    this.y = y;
    this.m = m;
    this.n = n;
  }
  
  Idx next() {
    if (x == m - 1 && y == n - 1) {
      x = -1;
      y = -1;
      return this;
    }
    
    if (y < n - 1) {
      y = y + 1;
      return this;
    } else {
      x = x + 1;
      y = 0;
      return this;
    }
  }
  
  boolean isEnd() {
    return x == -1 && y == -1;
  }
  
  void reset() {
    this.x = 0;
    this.y = 0;
  }

}