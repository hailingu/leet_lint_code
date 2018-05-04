// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 6.

#ifndef LEETLINTCODE_LINTCODE_ZIGZAGCONVERSION_CPP
#define LEETLINTCODE_LINTCODE_ZIGZAGCONVERSION_CPP

#include <iostream>
#include <math.h>

class ZigZagConversion {
 public:
   std::string convert(std::string s, int numRows) {
     std::string ret = "";
     int level = 0, internal = 0, inner_loop = 0;
     size_t len = s.size();
     if (1 == numRows) internal = 1;
     else internal = (numRows - 1) << 1;

     while (level < numRows) {
       inner_loop = level;
       if (level < len) ret += s[level];
       if ((level % numRows) == 0 || (level % numRows) == (numRows - 1)) {
         while (inner_loop + internal < len) {
           ret = ret + s[inner_loop + internal];
           inner_loop = inner_loop + internal;
         }
        } else {
          int temp_interal = internal - 2 * level;
          while (inner_loop + temp_interal < len) {
            ret = ret + s[inner_loop + temp_interal];
            inner_loop = inner_loop + temp_interal;
            temp_interal = internal - temp_interal;
          }
        }
        ++ level;
      }
      return ret;
    }

    // O(n)
    std::string convert2(std::string s, int numRows) {
      int divisor = (numRows - 1) << 1, current_index = 0;
      if (0 == divisor) return s;
      std::string ret = "";
      size_t len = s.size();
      int index1 = 0, index2 = 0, remainder1 = 0, remainder2 = 0;
      while (ret.size() != len) {
        remainder1 = current_index % divisor;
        remainder2 = (divisor - remainder1) % divisor;
        index1 = remainder1;
        if (remainder1 == remainder2) {
          while (index1 < len) {
            ret.append(s.substr(index1, 1));
            index1 += divisor;
          }
        } else {
          index2 = remainder2;
          while (index1 < len || index2 < len) {
            if (index1 < index2) {
              ret.append(s.substr(index1, 1));
              index1 += divisor;
            } else {
              ret.append(s.substr(index2, 1));
              index2 += divisor;
            }
          }
        }
      ++ current_index;
      }
      return ret;
    }
};

#endif
