// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 311.
// Date: 2019.7.29


class Multiply {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] ans = new int[A.length][B[0].length];
        
        for (int m = 0; m < B[0].length; ++ m) {
            for (int n = 0; n < B.length; ++ n) {
                if (B[n][m] != 0) {
                    for (int i = 0; i < A.length; ++ i) {
                        ans[i][m] +=  A[i][n] * B[n][m];
                    }
                }
            }
        }
        
        return ans;
    }
}