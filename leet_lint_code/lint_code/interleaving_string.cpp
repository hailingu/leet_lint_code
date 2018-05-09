// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 29.

#ifndef LEETLINTCODE_LINTCODE_INTERLEAVINGSTRING_CPP
#define LEETLINTCODE_LINTCODE_INTERLEAVINGSTRING_CPP

#include <iostream>

class InterleavingString {
 public:
   bool isInterleave(std::string &s1, std::string &s2, std::string &s3) {
     return isInterleaveHelp(s1, 0, s2, 0, s3, 0);
   }

  bool isInterleaveHelp(std::string &s1, int s1_index, std::string &s2, int s2_index, std::string &s3, int s3_index) {
    size_t len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
    if (len1 == s1_index && len2 == s2_index && len3 == s3_index) return true;

    if (len1 == s1_index + 1 && len2 == s2_index) {
      return s1[s1_index] == s3[s3_index] && s3_index == len3 - 1;
    } else if (len1 == s1_index && len2 == s2_index + 1) {
      return s2[s2_index] == s3[s3_index] && s3_index == len3 - 1;
    } else {
      if (s1[s1_index] == s3[s3_index] || s2[s2_index] == s3[s3_index]) {
        return isInterleaveHelp(s1, s1_index + 1, s2, s2_index, s3, s3_index + 1) ||
               isInterleaveHelp(s1, s1_index, s2, s2_index + 1, s3, s3_index + 1);
      } else return false;
    }
  }
};

#endif // LEETLINTCODE_LINTCODE_INTERLEAVINGSTRING_CPP
