// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 84.

#ifndef LEETLINTCODE_LINTCODE_SIGNLENUMBERIII_CPP
#define LEETLINTCODE_LINTCODE_SIGNLENUMBERIII_CPP

#include <vector>

class SingleNumberIII {
 public:
   std::vector<int> singleNumberIII(std::vector<int> &A) {
      int a = 0;
      std::vector<int> result(2, 0);
      for (int i = 0; i < A.size(); ++ i)
        a = a ^ A[i];

      a &= - a;
      for (int i = 0; i < A.size(); ++ i) {
        if (a & A[i]) result[0] ^= A[i];
        else result[1] ^= A[i];
      }

      return result;
   }
};

#endif // LEETLINTCODE_LINTCODE_SIGNLENUMBERIII_CPP
