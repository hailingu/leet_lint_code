// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 45.

#ifndef LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAYDIFFERENCE_CPP
#define LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAYDIFFERENCE_CPP

const int MIN = -2147483648;
const int MAX =  2147483647;

#include <vector>

class MinMax {
 public:

   MinMax() {
     min = MAX;
     max = MIN;
   }

   int min;
   int max;
};

class MaximumSubarrayDifference {
 public:
    int maxDiffSubArrays(std::vector<int> &nums) {
      int len = (int)nums.size();
      if (1 >= len) return 0;
      
      std::vector<MinMax> r_min_max(len, MinMax());
      rightMinMax(r_min_max, nums);
      int i = 1, l_min = MAX, l_max = MIN, ts_min = 0, ts_max = 0, end = len, max_diff = MIN, tmp_diff;
      while (i < end) {
        ts_min += nums[i - 1];
        ts_max += nums[i - 1];
        
        if (ts_min < l_min) l_min = ts_min;
        if (ts_min > 0) ts_min = 0;
        
        if (ts_max > l_max) l_max = ts_max;
        if (ts_max < 0) ts_max = 0;
        
        MinMax r = r_min_max[i];
        tmp_diff = l_max - r.min > r.max - l_min ? l_max - r.min : r.max - l_min;
        if (tmp_diff > max_diff) max_diff = tmp_diff;
        ++ i;
      }
      
      return max_diff;
    }
  
  inline void rightMinMax(std::vector<MinMax>& v, std::vector<int> &nums) {
    int i = nums.size() - 1, ts_min = 0, ts_max = 0,  r_min = MAX, r_max = MIN;
    while (i > 0) {
      ts_min += nums[i];
      ts_max += nums[i];
      
      if (ts_min < r_min) r_min = ts_min;
      if (ts_min > 0) ts_min = 0;
      
      if (ts_max > r_max) r_max = ts_max;
      if (ts_max < 0) ts_max = 0;
      
      v[i].min = r_min;
      v[i].max = r_max;
      -- i;
    }
  }
};

#endif // LEETLINTCODE_LINTCODE_MAXIMUMSUBARRAYDIFFERENCE_CPP
