// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 888.
// Date: 2019.8.21

class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int totalA = 0;
        int totalB = 0;
        for (int i : A) {
            totalA += i;
        }
        
        for (int i : B) {
            totalB += i;
        }
        
        int[] ans = new int[2];
        boolean find = false;
        for (int i : A) {
            for (int j : B) {
                if (totalA - i + j == totalB + i - j) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }

        }
        
        return ans;
    }
}