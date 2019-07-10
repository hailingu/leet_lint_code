// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 910.
// Date: 2019.7.10

import java.util.Arrays;

public class SmallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0];
        int max = A[A.length - 1];

        int ans = max - min;
        for (int i = 1; i < A.length; ++ i) {
            ans = Math.min(Math.max(max - K, A[i - 1] + K) - Math.min(min + K, A[i] - K), ans);
        }

        return ans;
    }
}
