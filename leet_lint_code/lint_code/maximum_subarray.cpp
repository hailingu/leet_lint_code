// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 41.

#ifndef LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAY_CPP
#define LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAY_CPP

#include <vector>

class MaximumSubarray {
 public:
  int maxSubArray(std::vector<int> &nums) {
    int max = nums[0], temp_left = 0, len = (int)nums.size(), i = 0;
    while (i != len) {
      temp_left += nums[i ++];
      if (temp_left > max) max = temp_left;
      if (temp_left < 0) temp_left = 0;
    }
    return max;
  }
};


#endif // LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAY_CPP
