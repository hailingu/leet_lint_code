// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 1.

#ifndef LEETLINTCODE_LINTCODE_APLUSB_CPP
#define LEETLINTCODE_LINTCODE_APLUSB_CPP

#include <stdio.h>

class APlusB {
 public:
   int aplusb(int a, int b) {
     while (b) {
         int t = a;
         a = b ^ a;
         b = (b & t) << 1;
     }
     return a;
  }
};

#endif // LEETLINTCODE_LINTCODE_APLUSB_CPP
