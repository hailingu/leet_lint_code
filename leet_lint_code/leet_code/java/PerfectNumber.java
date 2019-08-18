// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: leetcode
// This is a answer of leet code problem 517.
// Date: 2019.8.18

class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        int ans = 1;
        if (num == 1) {
            return false;
        }
        
        int upper = (int)Math.sqrt(num);
        for (int i = 2; i <= upper; ++ i) {
            if (num % i == 0) {
                ans += ( i + num / i);
            }
        }
        
        return ans == num;
    }
}