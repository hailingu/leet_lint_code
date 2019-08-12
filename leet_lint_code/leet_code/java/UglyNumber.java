// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 263.
// Date: 2019.8.12


class UglyNumber {
    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        
        if (num <= 0) {
            return false;
        }
        
        while(num > 1) {
            if (num % 5 == 0) {
                num /= 5;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 2 == 0) {
                num /= 2;
            } else {
                return false;
            }
        }
        return true;
    }
}