// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 366.

#ifndef LEETLINTCODE_LINTCODE_FIBONACCI_CPP
#define LEETLINTCODE_LINTCODE_FIBONACCI_CPP

#include <vector>

class Fibonacci {
 public:
   int fibonacci(int n) {
     if (1 == n) return 0;
     if (2 == n) return 1;
     std::vector<int> v;
     v.push_back(0);
     v.push_back(1);
     int i = 1, j = 0;
     while(i < n) v.push_back(v[i++] + v[j++]);
     return v[n-1];
    }
};

#endif // LEETLINTCODE_LINTCODE_FIBONACCI_CPP
