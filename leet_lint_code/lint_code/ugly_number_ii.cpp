// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 4.

#ifndef LEETLINTCODE_LINTCODE_UGLYNUMBERII_CPP
#define LEETLINTCODE_LINTCODE_UGLYNUMBERII_CPP

#include <stdio.h>
#include <vector>

class UglyNumberII{
 public:
   int nthUglyNumber(int n) {
    if (1 == n) return n;
    std::vector<int> v;

    int two = 0, three = 0, five = 0;
    int multiply_two = 2, multipy_three = 3, multiply_five = 5;
    int min_number = 1;

    v.push_back(1);

    for (int i = 0; i < n; ++ i) {
      min_number = minNumber(multiply_two, multipy_three, multiply_five);
      v.push_back(min_number);
      if (min_number == multiply_two)  multiply_two = 2 * v[++ two];
      if (min_number == multipy_three)  multipy_three = 3 * v[++ three];
      if (min_number == multiply_five) multiply_five = 5 * v[++ five];
    }

    return v[n - 1];
   }

   int minNumber(int a, int b, int c) {
     a = a < b ? a : b;
     return c < a ? c : a;
   }
};

#endif // LEETLINTCODE_LINTCODE_UGLYNUMBERII_CPP
