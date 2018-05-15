// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 42.

#ifndef LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAYII_CPP
#define LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAYII_CPP

#include <vector>

class MaximumSubarrayII {
 public:
  int maxTwoSubArrays(std::vector<int> &nums) {
    int len = (int)nums.size();
    unsigned int zero = 0;
    int MIN = ((~zero) >> 1)  + 1;
    int max = MIN;
    if (1 == len) return max;
    if (2 == len) return nums[0] + nums[1];

    std::vector<int> max_cnt(len, MIN);

    int i = 0, tmp = 0, right = 0, left = MIN, temp_left = 0;
    while (i != len - 1) {
      update(temp_left, nums[i], left);
      tmp = left + maxSubArrayRight(nums, len - 1, i + 1, max_cnt, MIN);
      if (tmp > max) max = tmp;
      ++ i;
    }
    return max;
  }

  inline int maxSubArrayRight(std::vector<int> &nums, int begin, int end,
    std::vector<int> &max_cnt, int &min) {
      if (max_cnt[end] != min) return max_cnt[end];
      int max = min, temp_right = 0, i = begin;
      while (i != end) {
        update(temp_right, nums[i], max);
        max_cnt[i] = max;
        -- i;
      }
      return max;
   }

 inline void update(int &tmp_direct, int &nums, int &max) {
   tmp_direct += nums;
   if (tmp_direct > max) max = tmp_direct;
   if (tmp_direct < 0) tmp_direct = 0;
 }
};

#endif // LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAYII_CPP
