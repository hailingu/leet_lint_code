// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 79.

#ifndef LEETLINTCODE_LINTCODE_LONGESTCOMMONSUBSTRING_CPP
#define LEETLINTCODE_LINTCODE_LONGESTCOMMONSUBSTRING_CPP

#include <vector>
#include <map>
#include <string>
#include <iostream>

class LongestCommonSubsequence {
 public:
   int longestCommonSubstring(string &A, string &B) {
       std::vector<std::vector<int>> match_info(A.length(), std::vector<int>(B.length(), -1));
       longestCommonSubstringHelp(A,B, (int)A.length() - 1, (int)B.length() - 1, match_info);
       int max = 0;
       for (int i = 0; i < match_info.size(); ++ i) {
           for (int j = 0; j < match_info[i].size(); ++ j)
               if (max < match_info[i][j]) max = match_info[i][j];
       }
       return max;
   }

  int longestCommonSubstringHelp(std::string &A, std::string &B,
                                   int a_index, int b_index,
                                   std::vector<std::vector<int>> &match_info) {
    if (a_index < 0 || b_index < 0) return 0;
    if (-1 != match_info[a_index][b_index]) return match_info[a_index][b_index];
    int prev = longestCommonSubstringHelp(A, B, a_index - 1, b_index - 1, match_info);
    int upper = longestCommonSubstringHelp(A, B, a_index, b_index - 1, match_info);
    int left  = longestCommonSubstringHelp(A, B, a_index - 1, b_index, match_info);
    if (A[a_index] == B[b_index]) {
      match_info[a_index][b_index] = 1 + prev;
    } else {
      match_info[a_index][b_index] = 0;
      return match_info[a_index][b_index];
    }
  }
};

#endif // LEETLINTCODE_LINTCODE_LONGESTCOMMONSUBSTRING_CPP
