// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 908.
// Date: 2019.7.9

import java.util.Arrays;

public class SmallestRangeI {

    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0];
        int max = A[A.length - 1];
        return Math.max(max - min - 2 * K, 0);
    }
}