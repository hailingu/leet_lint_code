// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 2.

#ifndef LEETLINTCODE_LINTCODE_TRAILINGZEROS_CPP
#define LEETLINTCODE_LINTCODE_TRAILINGZEROS_CPP

#include <stdio.h>

class TrailingZeros {
 public:
   long long trailingZeros(long long n) {
     long long total = 0;
     long long count = 0;
     while (n > 0) {
       count = n / 5;
       total += count;
       n = count;
     }
     return total;
   }
};

#endif // LEETLINTCODE_LINTCODE_TRAILINGZEROS_CPP
