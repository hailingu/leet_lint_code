// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 6.

#ifndef LEETLINTCODE_LINTCODE_ZIGZAGCONVERSION_CPP
#define LEETLINTCODE_LINTCODE_ZIGZAGCONVERSION_CPP

class ZigZagConversion {
 public:
   std::string convert(std::string s, int nRows) {
     std::string ret = "";
     int level = 0, internal = 0, inner_loop = 0, len = s.size();
     if (0 != nRows - 1) internal = 2*nRows - 2;
     else internal = 1;

     while (level < nRows) {
       inner_loop = level;
       if (level < len) ret += s[level];
       if ((level % nRows) == 0 || (level % nRows) == (nRows - 1)) {
         while (inner_loop + internal < len) {
           ret = ret + s[inner_loop + internal];
           inner_loop = inner_loop + internal;
         }
        } else {
          int temp_interal = internal - 2*level;
          while (inner_loop + temp_interal < len) {
            ret = ret + s[inner_loop + temp_interal];
            inner_loop = inner_loop + temp_interal;
            temp_interal = internal - temp_interal;
          }
        }
        level ++;
      }
      return ret;
    }
};

#endif
