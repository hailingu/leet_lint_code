// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 76.

#ifndef LEETLINTCODE_LINTCODE_LONGESTINCREASINGSUBSEQUENCE_CPP
#define LEETLINTCODE_LINTCODE_LONGESTINCREASINGSUBSEQUENCE_CPP

#include <vector>
#include <map>

class LongestIncreasingSubsequence {
 public:
  int longestIncreasingSubsequence(std::vector<int> &nums) {
    int i = 0, len = (int)nums.size();
    if (0 == len) return 0;
    int tmp_cnt = 0;
    std::map<int, int> index_cnt;
    std::map<int, int>::iterator iter;
    while (i < len) {
      iter = index_cnt.begin();
      tmp_cnt = 1;
      while (iter != index_cnt.end()) {
        if (nums[i] > iter->first) {
          if (tmp_cnt < iter->second + 1)
            tmp_cnt = iter->second + 1;
        }
        ++ iter;
      }
      index_cnt[nums[i]] = tmp_cnt;
      ++ i;
    }
    
    int max = -1;
    for (std::map<int, int>::iterator iter = index_cnt.begin(); iter != index_cnt.end(); ++ iter)
      if (iter->second > max)
        max = iter->second;
    return max;
  }
};

#endif // LEETLINTCODE_LINTCODE_LONGESTINCREASINGSUBSEQUENCE_CPP
