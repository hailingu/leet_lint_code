// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 37.

#ifndef LEETLINTCODE_LINTCODE_REVERSE3DIGITINTEGER_CPP
#define LEETLINTCODE_LINTCODE_REVERSE3DIGITINTEGER_CPP

class Reverse3digitInteger {
 public:
   int reverseInteger(int number) {
     if (number < 100) return number;

     int hundreds = number / 100;
     int decade = number % 100;
     int unit = number % 10;

     return unit * 100 + decade + hundreds - unit;
   }
};

#endif // LEETLINTCODE_LINTCODE_REVERSE3DIGITINTEGER_CPP
