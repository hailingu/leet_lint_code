// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 896.
// Date: 2019.8.22

class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
          return true;
        }
      
        int sgn = A[1] - A[0];
        for (int i = 2; i < A.length; ++ i) {
          int diff = A[i] - A[i - 1];
          if (sgn == 0) {
            sgn = diff;
          } else {
            if (diff != 0 && diff * sgn < 0) {
              return false; 
            }
          }
        }
        return true;
    }
}