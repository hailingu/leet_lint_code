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
    if (n == 0 && k == 0) return 1;

    int base = 1;
    int total = 0;
    int i = 1;
    int q = 10;

    int current_digit = n % 10;
    int last_digit = current_digit;

    if (last_digit >= k) total = 1;

    n = n / 10;

    while (0 < n) {
      current_digit = n % 10;

      if (0 != k) {
        base = i * q / 10;
        total += current_digit * base;
        if (current_digit > k)  total += q;
        else if (current_digit == k) total += (last_digit  + 1);
      } else {
        total += current_digit * base;
        base = base * 10 + 1;
      }

      if (0 < i) last_digit = current_digit * q + last_digit;
      i = i + 1;
      n = n / 10;
      q = q * 10;
    }

    return total;
    }
};

#endif // LEETLINTCODE_LINTCODE_DIGITCOUNTS_CPP
