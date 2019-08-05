// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 276.
// Date: 2019.8.6


class PaintFence {
    
    public int numWays(int n, int k) {
        int[] memo = new int[n + 1];
        return numWaysHelp(n, k, memo);  
    }
    
    int numWaysHelp(int n, int k, int[] memo) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return k;
        }
        
        if (n == 2) {
            return k * k;
        }
        
        if (memo[n] > 0) {
            return memo[n];
        }
        
        memo[n] = (numWaysHelp(n - 1, k, memo)  + numWaysHelp(n - 2, k, memo)) * (k-1);
        return memo[n];
    }
}