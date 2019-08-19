// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 231.
// Date: 2019.8.20

class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n == -2147483648) {
            return false;
        }
        
        n = n & (n - 1);
        return  n == 0;
    }
}