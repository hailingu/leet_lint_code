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
     long ret = 0;

      while (0 != x) {
        ret = ret * 10 + x % 10;
        x = x / 10;
      }

      if (ret > MAX || ret < MIN) return 0;
      return (int)ret;
   }
};

#endif // LEETLINTCODE_LINTCODE_REVERSEINTEGER_CPP
