// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 14.

#ifndef LEETLINTCODE_LINTCODE_LONGESTCOMMONPREFIX_CPP
#define LEETLINTCODE_LINTCODE_LONGESTCOMMONPREFIX_CPP

#include <vector>
#include <map>
#include <string>
#include <iostream>

class LongestCommonPrefix {
 public:
    std::string longestCommonPrefix(std::vector<std::string> &strs) {
      int len = (int)strs.size();
      if (0 == len) return "";
      if (1 == len) return strs[0];

      int i = -1;
      while (true) {
        int j = 0;
        while (j < len - 1) {
          if (i == -1 && strs[j][0] == strs[j + 1][0]) ++ j;
          else if (strs[j][i] == strs[j + 1][i]) ++ j;
          else break;
        }
        if (j != len - 1) break;
        ++ i;
      }

      return strs[0].substr(0, i);
    }
};

#endif // LEETLINTCODE_LINTCODE_LONGESTCOMMONPREFIX_CPP
