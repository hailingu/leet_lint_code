// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 954.
// Date: 2019.8.28


import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);
        int ans = 0;
        int i = A[0];
        for (int a : A) {
            if (i > a) {
                ans += i - a;
                i ++;
            } else {
                i = a;
            }
        }

        return ans;
    }
}
