// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 867.
// Date: 2019.7.29

class Transpose {
    public int[][] transpose(int[][] A) {
        int[][] ans = new int[A[0].length][A.length];
        
        for (int m = 0; m < A.length; ++ m) {
            for (int n = 0; n < A[0].length; ++n) {
                ans[n][m] = A[m][n];
            }
        }
        
        
        return ans;
    }
}