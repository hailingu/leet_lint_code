// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 53.

#ifndef LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAY_CPP
#define LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAY_CPP

#include <vector>

class MaximumSubarray {
 public:
  int maxSubArray(vector<int> &nums) {
    int max = 0, temp_left = 0, len = (int)nums.size(), i = 0, tmp = 0;
    while (i < len) {
      if (0 == i) {
        if (nums[i] > 0) temp_left = nums[i];
        max = nums[i];
      } else {
        tmp = temp_left + nums[i];
        if (temp_left > 0)
          max = max > tmp ? max : tmp;
        else
          max = max > nums[i] ? max : nums[i];
        if (tmp > 0) temp_left = tmp;
          else temp_left = 0;
      }
      ++ i;
    }
    return max;
  }
};


#endif // LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAY_CPP
