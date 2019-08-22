// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 832.
// Date: 2019.8.23

class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; ++ i) {
          for (int m = 0, n = A[i].length -1 ; m < n; ++ m, --n) {
            int t = A[i][m];
            A[i][m] = A[i][n];
            A[i][n] = t;
          }
        } 
        
      for (int i = 0; i < A.length; ++ i) {
        for (int j = 0; j < A[0].length; ++ j) {
          A[i][j] = A[i][j] == 0 ? 1 : 0;
        }
      }
      
      return A;
    }
}