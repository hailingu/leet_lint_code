// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 8.

#ifndef LEETLINTCODE_LINTCODE_ROTATESTRING_CPP
#define LEETLINTCODE_LINTCODE_ROTATESTRING_CPP

#include <iostream>
#include <vector>

class RotateString {
 public:
    // O(1)
   void rotateString(std::string& str, int offset) {
     int len = (int)str.length();
     if (0 == len) return;
     int i = 0;
     offset = offset % len;
     while (i ++  < offset) rotateOne(str, len);
   }

  void rotateOne(std::string& str, int len) {
    char ch = str[len - 1];
    int j = len - 1;
    while (0 < j) {
      str[j] = str[j - 1];
      -- j;
    }
    str[0] = ch;
  }

  void rotateString2(std::string &str, int offset) {
    std::string s = "";
    int len = (int)str.length();
    int i = len - offset;
    while (i < len) s = s + str[i ++];
    int j = 0;
    i = len - offset;
    while (j < i) s = s + str[j ++];
    str = s;
  }
};

#endif // LEETLINTCODE_LINTCODE_ROTATESTRING_CPP
