// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 83.

#ifndef LEETLINTCODE_LINTCODE_SIGNLENUMBERII_CPP
#define LEETLINTCODE_LINTCODE_SIGNLENUMBER_CPP

#include <vector>

class SingleNumberII {
 public:
   int singleNumberII(vector<int> &A) {
       int a = 0, b = 0;
       for (int i = 0; i < A.size(); ++ i) {
           b = (b ^ A[i]) & ~a;
           a = (a ^ A[i]) & ~b;
       }
       return b;
   }
};

#endif // LEETLINTCODE_LINTCODE_SIGNLENUMBERII_CPP
