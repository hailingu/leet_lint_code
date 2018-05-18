// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 44.

#ifndef LEETLINTCODE_LINTCODE_MINIMUSSUBARRAY_CPP
#define LEETLINTCODE_LINTCODE_MINIMUSSUBARRAY_CPP


class Minimum Subarray {
 public:
    int minSubArray(vector<int> &nums) {
      int min = nums[0], temp_left = 0, len = (int)nums.size(), i = 0;
      while (i != len) {
        temp_left += nums[i ++];
        if (temp_left < min) min = temp_left;
        if (temp_left > 0) temp_left = 0;
      }
      return min;
    }
};

#endif // LEETLINTCODE_LINTCODE_MINIMUSSUBARRAY_CPP
