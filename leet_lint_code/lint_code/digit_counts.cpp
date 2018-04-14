// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 3.

#ifndef LEETLINTCODE_LINTCODE_DIGITCOUNTS_CPP
#define LEETLINTCODE_LINTCODE_DIGITCOUNTS_CPP

#include <stdio.h>
#include <math.h>

class DigitCounts{
 public:
   int digitCounts(int k, int n) {
     int current_digit = 0;
     int last_digit = -1;
     int base = 1;
     int total = 0;
     int i = 0;

     if (n == 0 && k == 0) return 1;

     while (n > 0) {
       current_digit = n % 10;

        if (last_digit == -1) {
            last_digit = current_digit;
            if (last_digit >= k) total = 1;
        } else {
            if (k != 0) {
                 base = i * pow(10, i - 1);
                 if (current_digit > k) total = total + current_digit * base + pow(10, i);
                 else if (current_digit == k) total = total + current_digit * base + last_digit  + 1;
                 else total = total + current_digit * base;
            } else  {
             total = current_digit * base + total;
             base = base * 10 + 1;
            }
        }

        if (i > 0) last_digit = current_digit * pow(10, i) + last_digit;
        i = i + 1;
        n = n / 10;
     }

     return total;
   }
};

#endif // LEETLINTCODE_LINTCODE_DIGITCOUNTS_CPP
