// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 54.

#ifndef LEETLINTCODE_LINTCODE_STRINGTOINTEGER_CPP
#define LEETLINTCODE_LINTCODE_STRINGTOINTEGER_CPP

#include <iostream>

class StringToInteger {
 public:
   int myAtoi(std::string str) {
     unsigned int zero = 0;
     int MAX = (~zero) >> 1;
     int MIN = MAX + 1;
     int max_lower = MAX / 10, min_lower = MIN / 10;
     int len = (int)str.length(), ret = 0, sign = 1, index = 0;
     if (0 == len ) return ret;

     bool begin = false;
     while (index < len) {
       if (str[index] != ' ' &&
           str[index] != '+' &&
           str[index] != '-' &&
           (str[index] < '0' || str[index] > '9')) break;

      if (!begin) {
        if (' ' == str[index]) {
          ++ index;
          continue;
        }
        if ('+' == str[index] || '-' == str[index]) {
          begin = true;
          if ('-' == str[index ++ ]) sign = -1;
          continue;
        }
      } else if (str[index] < '0' || str[index] > '9') break;

      if (ret > max_lower) return MAX;
      if (ret < min_lower) return MIN;

      begin = true;
      ret = ret * 10  + sign * (str[index ++] - '0');
     }

     if (sign == 1 && ret < 0) return MAX;
     if (sign == -1 && ret > 0) return MIN;
     return ret;
   }
};

#endif // LEETLINTCODE_LINTCODE_STRINGTOINTEGER_CPP
