// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1004.
// Date: 2019.7.15

class LongestOnes {
    public int longestOnes(int[] A, int K) {
        int[] dpk = new int[K + 1];
        
        int ans = 0;
        for (int i = 0; i < A.length; ++ i) {
            if (A[i] == 1) {
                for (int j = 0; j < K + 1; ++ j) {
                    dpk[j] += 1;
                }
            } else {
                for (int j = K; j > 0; -- j) {
                    dpk[j] = dpk[j-1] + 1;
                }
                dpk[0] = 0;
            }
            
            ans = Math.max(ans, dpk[K]);
        }
        
        return ans;
    }
}