// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 43.

#ifndef LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAYIII_CPP
#define LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAYIII_CPP

#include <vector>
#include <iostream>
#include <math.h>

class MaximumSubarray {
  public:
    int maxSubArray(std::vector<int> &nums, int k) {
      unsigned int zero = 0;
      int MIN = ((~zero) >> 1)  + 1;
      int len = (int)nums.size();

      if (len < k) return MIN;
      std::vector<std::vector<int> > tmp_result;
      std::vector<std::vector<int> > result;

      int i = 0;
      while (i ++ <= len) {
        std::vector<int> tmp(k + 1, 0);
        tmp_result.push_back(tmp);
        result.push_back(tmp);
      }

      i = 1;
      int j = 0;
      while (i <= k) {
        j = i;
        tmp_result[j - 1][j] = MIN;
        while (j <= len) {
          tmp_result[j][i] = std::max(result[j - 1][i - 1], tmp_result[j - 1][i]) + nums[j - 1];
          if (i == j) result[j][i] = tmp_result[j][i];
          else result[j][i] = std::max(tmp_result[j][i], result[j - 1][i]);
          ++ j;
        }
        ++ i;
      }
      return result[len][k];
    }
  };

#endif // LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAYIII_CPP
