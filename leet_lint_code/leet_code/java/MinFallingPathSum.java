// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 931.
// Date: 2019.8.5

import java.util.Arrays;

class MinFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        int[][] memo = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; ++ i) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < A[0].length; ++ i) {
            min = Math.min(backtrack(A, 0, i, 0, memo), min);
        }
        return min;
    }

    int backtrack(int[][] A, int level, int idx, int init, int[][] memo) {
        if (level == A.length) {
            return 0;
        }

        if (memo[level][idx] != Integer.MAX_VALUE) {
            return memo[level][idx];
        }
        
        int min0 = backtrack(A, level + 1, idx, 0, memo);
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        if (idx - 1 >= 0) {
            min1 = backtrack(A, level + 1, idx - 1, 0, memo);
        }

        if (idx + 1 < A[0].length) {
            min2 = backtrack(A, level + 1, idx + 1, 0, memo);
        }

        memo[level][idx] = Math.min(min0, Math.min(min1, min2)) + A[level][idx];
        return memo[level][idx];
    }
}