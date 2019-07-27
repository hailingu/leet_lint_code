// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1064.
// Date: 2019.7.27

class FixedPoint {
    public int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; ++ i) {
            if (A[i] == i) {
                return i;
            }
        }
        
        return -1;
    }
}