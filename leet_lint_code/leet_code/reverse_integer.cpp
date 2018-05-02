// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 7.

#ifndef LEETLINTCODE_LINTCODE_REVERSEINTEGER_CPP
#define LEETLINTCODE_LINTCODE_REVERSEINTEGER_CPP

class ReverseInteger {
 public:
   int reverse(int x) {
     unsigned int zero = 0;
     int MAX = (~zero) >> 1;
     int MIN = MAX + 1;
     if (MIN == x || MAX == x) return 0;
     int ret = 0;

      while (0 != x) {
        if (ret > MAX / 10 || ret < MIN / 10) return 0;
        ret = ret * 10 + x % 10;
        x = x / 10;
      }
      return ret;
   }
};

#endif // LEETLINTCODE_LINTCODE_REVERSEINTEGER_CPP
