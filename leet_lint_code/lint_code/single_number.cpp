// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 82.

#ifndef LEETLINTCODE_LINTCODE_SIGNLENUMBER_CPP
#define LEETLINTCODE_LINTCODE_SIGNLENUMBER_CPP

#include <vector>

class SingleNumber {
 public:
   int singleNumber(vector<int> &A) {
       int single_num = A[0];
       for (int i = 1; i < A.size(); ++ i) {
           single_num = single_num ^ A[i];
       }
       return single_num;
   }
};

#endif // LEETLINTCODE_LINTCODE_SIGNLENUMBER_CPP
