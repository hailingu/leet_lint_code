// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 107.

#ifndef LEETLINTCODE_LINTCODE_WORDBREAK_CPP
#define LEETLINTCODE_LINTCODE_WORDBREAK_CPP

#include <string>
#include <vector>
#include <set>
#include <iostream>
#include <unordered_set>
#include <math.h>

class WordBreak {
 public:
  bool wordBreak(std::string &s, std::unordered_set<std::string> &dict) {
     if (0 == s.length()) return true;
      std::vector<bool> history(s.length(), false);
      wordBreakHelp(s, dict, 0, 0,history);
      return history[0];
    }

  bool wordBreakHelp(std::string &s, std::unordered_set<std::string> &dict, int index, int pre_index, std::vector<bool> &history) {
    if (index > s.length()) return false;
    if (index == s.length()) return true;
    if (history[index]) return history[index];
    for (int i = 1; i <= s.length() - index; ++ i) {
      if (dict.find(s.substr(index, i)) != dict.end())
        history[pre_index] =  wordBreakHelp(s, dict, index + i, index, history);
      if (history[pre_index]) return true;
    }
    return history[pre_index];
  }
};

#endif // LEETLINTCODE_LINTCODE_WORDBREAK_CPP
