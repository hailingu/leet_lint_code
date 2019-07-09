// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 908.
// Date: 2019.7.9

public class SmallestRangeI {

    public int smallestRangeI(int[] A, int K) {
        int min = 10000;
        int max = -1;

        for (int i = 0; i < A.length; ++ i) {
            if (A[i] < min) {
                min = A[i];
            }

            if (A[i] > max) {
                max = A[i];
            }
        }

        return Math.max(max - min - 2 * K, 0);
    }
}