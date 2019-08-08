// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 461.
// Date: 2019.8.9

class HammingDistance {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        x = x ^ y;
        while (x > 0) {
            ans ++;
            x = x & (x - 1);
        }
        
        return ans;
        return ans;
    }
}