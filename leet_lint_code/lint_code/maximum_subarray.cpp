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
    unsigned int zero = 0;
    int min = ((~zero) >> 1)  + 1;
    int max = min, temp_left = 0, len = (int)nums.size(), i = 0, tmp = 0;
    while (i != len) {
      tmp = temp_left + nums[i];
      if (temp_left > 0) max = max > tmp ? max : tmp;
      else max = max > nums[i] ? max : nums[i];
      if (tmp > 0) temp_left = tmp;
      else temp_left = 0;
      ++ i;
    }
    return max;
  }
};


#endif // LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAY_CPP
