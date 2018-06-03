// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 77.

#ifndef LEETLINTCODE_LINTCODE_LONGESTCOMMONSUBSEQUENCE_CPP
#define LEETLINTCODE_LINTCODE_LONGESTCOMMONSUBSEQUENCE_CPP

#include <vector>
#include <map>
#include <string>
#include <iostream>

class LongestCommonSubsequence {
 public:
   int longestCommonSubsequence(std::string &B, std::string &A) {
     std::vector<std::vector<int>> match_info(A.length(), std::vector<int>(B.length(), -1));
     int r =  longestCommonSubsequenceHelp(A, B, (int)A.length() - 1, (int)B.length() - 1, match_info);
     return r;
   }

   int longestCommonSubsequenceHelp(std::string &A, std::string &B,
                                    int a_index, int b_index,
                                    std::vector<std::vector<int>> &match_info) {
     if (a_index < 0 || b_index < 0) return 0;
     if (-1 != match_info[a_index][b_index]) return match_info[a_index][b_index];
     if (A[a_index] == B[b_index]) {
       match_info[a_index][b_index] = 1 +  longestCommonSubsequenceHelp(A, B, a_index - 1, b_index - 1, match_info);
     } else {
       int left = longestCommonSubsequenceHelp(A, B, a_index, b_index - 1, match_info);
       int diagonal = longestCommonSubsequenceHelp(A, B, a_index - 1, b_index - 1, match_info);
       int upper = longestCommonSubsequenceHelp(A, B, a_index - 1, b_index, match_info);
       int max_value = std::max(diagonal, left);
       max_value = std::max(max_value, upper);
       match_info[a_index][b_index] = max_value;
     }
     return match_info[a_index][b_index];
   }
};

#endif // LEETLINTCODE_LINTCODE_LONGESTCOMMONSUBSEQUENCE_CPP
