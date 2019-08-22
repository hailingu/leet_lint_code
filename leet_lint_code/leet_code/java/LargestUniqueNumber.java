// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 1133.
// Date: 2019.8.22

import java.util.Arrays;

class Solution {
    public int largestUniqueNumber(int[] A) {
        Arrays.sort(A);
        
        for (int i = A.length - 1; i >= 0;) {
            int j =  i - 1;
            while (j >= 0 && A[j] == A[i]) { -- j;}
            if (i - j > 1) {
                i = j;
            } else {
                return A[i];
            }
        }
        
        return -1;
    }
}