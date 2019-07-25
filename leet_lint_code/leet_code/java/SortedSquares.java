// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 977.
// Date: 2019.7.26

class SortedSquares {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];

        int aos = 0;
        int q = 0;
        int i = 0;
        while (i < A.length && A[i] < aos) {
            ++ i;
        }
        
        
        int j = i - 1;
        while (j >= 0 && i < A.length) {
            if (A[i] - aos > aos - A[j]) {
                ans[q ++] = A[j] * A[j];
                -- j;
            } else {
                ans[q ++] = A[i] * A[i];
                ++i;
            }
        }
        
        while (j >= 0) {
            ans[q++] =  A[j] * A[j];
            -- j;
        }
            
        while (i < A.length) {
            ans[q ++] = A[i] * A[i];
            ++ i;
        }
        
        return ans;
    }
}