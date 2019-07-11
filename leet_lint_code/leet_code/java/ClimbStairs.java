// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 70.
// Date: 2019.7.11

class ClimbStairs {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        
        int[] mem = new int[n + 1];
        mem[1] = 1;
        mem[2] = 1 + mem[1];
        
        climbStairsHelp(n, mem);
        return mem[n];
    }
    
    int climbStairsHelp(int n, int[] mem) {
        if (mem[n] > 0) {
            return mem[n];
        } else {
            mem[n] = climbStairsHelp(n - 1, mem) + climbStairsHelp(n - 2, mem);
            return mem[n];
        }
    }
}