// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 1015.
// Date: 2019.7.13

class Solution {
    public int SmallestRepunitDivByK(int K) {
        
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        
        int residual = 1;
        int result = 1;
        int t = 1;
        while (residual % K != 0) {
            t = (t * 10) % K;
            residual = residual + t;
            result ++;
        }
        
        return result;
    }
}