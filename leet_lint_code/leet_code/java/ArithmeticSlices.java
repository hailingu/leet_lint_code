// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 413.
// Date: 2019.8.7

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }



        int ans = 0;
        int i = 0;
        int j = 1;

        while (i < A.length - 1 && j < A.length) {
            int cnt = 2;
            int q = j;
            int dist = A[j] - A[i];
            while (q < A.length - 1 && A[q] + dist == A[q + 1]) {
                ++ cnt;
                ++ q;
            }

            if (cnt >= 3) {
                int n = cnt - 2;
                ans += (n + 1) * n / 2;
            }
            i = q;
            j = i + 1;
        }

        return ans;
    }
}
