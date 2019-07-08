// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 9.
// Date: 2019.7.8

#ifndef LEETLINTCODE_LINTCODE_ISPALINDROME_CPP
#define LEETLINTCODE_LINTCODE_ISPALINDROME_CPP

class Solution
{
public:
    bool isPalindrome(int x)
    {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
};

#endif LEETLINTCODE_LINTCODE_ISPALINDROME_CPP

