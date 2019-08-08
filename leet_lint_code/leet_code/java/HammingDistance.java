// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 461.
// Date: 2019.8.9

class HammingDistance {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        if (x == y) {
            return ans;
        }
        
        int lastDigitX;
        int lastDigitY;
        
        while (x > 0 && y > 0) {
            lastDigitX = x & 1;
            x = x >>> 1;
            lastDigitY = y & 1;
            y = y >>> 1;
            
            if (lastDigitX != lastDigitY) {
                ans ++ ;
            }
        }
        
        while (x > 0) {
            x = x & (x - 1);
            ans ++;
        }
        
        while (y > 0) {
            y = y & (y - 1);
            ans ++;
        }
        
        return ans;
    }
}