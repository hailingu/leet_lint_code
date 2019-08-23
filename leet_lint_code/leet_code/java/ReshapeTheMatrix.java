// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 566.
// Date: 2019.8.23

class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = m > 0 ? nums[0].length : 0;
        int count = m * n;
        if (count != r * c) {
          return nums;
        }
      
        int[][] ans = new int[r][c];
      
        Idx origin = new Idx(0, 0, m, n);
        Idx target = new Idx(0, 0, r, c);
      
        int i = 0;
        while (i < count) {
          ans[target.x][target.y] = nums[origin.x][origin.y];
          target.next();
          origin.next();
          ++ i;
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

}