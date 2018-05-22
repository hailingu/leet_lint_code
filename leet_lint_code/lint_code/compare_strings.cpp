// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 55.

#ifndef LEETLINTCODE_LINTCODE_COMPARESTRINGS_CPP
#define LEETLINTCODE_LINTCODE_COMPARESTRINGS_CPP

#include <string>
#include <map>

class CompareStrings {
public:
    bool compareStrings(std::string &A, std::string &B) {
      std::string source = A, target = B;
      size_t s_len = source.length(), t_len = target.length();
      int i = 0, min_len = (int)s_len+1, cnt = (int)t_len, min_begin = 0, min_end = 0;
      int queue_begin_index = 0;

      std::map<char, int> char_set;
      while (i < t_len) {
        if (char_set[target[i]]) ++ char_set[target[i]];
        else char_set[target[i]] = 1;
        ++ i;
      }

      i = 0;
      while (i < s_len) {
        if (char_set.find(source[i]) != char_set.end()) {
          if (char_set[source[i]] > 0) -- cnt;
          -- char_set[source[i]];

          if (0 == cnt)  break;
        }
      }

      return 0 == cnt;
    }
};

#endif // LEETLINTCODE_LINTCODE_COMPARESTRINGS_CPP
