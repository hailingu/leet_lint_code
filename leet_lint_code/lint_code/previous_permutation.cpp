// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 51.

#ifndef LEETLINTCODE_LINTCODE_PREVIOUSPERMUTATION_CPP
#define LEETLINTCODE_LINTCODE_PREVIOUSPERMUTATION_CPP

#include <vector>
#include <algorithm>

class PreviousPermutation {
 public:
    std::vector<int> previousPermuation(std::vector<int> &nums) {
      size_t len = nums.size();
      if (1 >= len) nums;

      int j = len - 1;
      while (j > 0 && nums[j] >= nums[j - 1]) -- j;

      std::vector<int>::iterator begin = nums.begin() + j;
      if (0 == j) {
          std::reverse(begin, nums.end());
          return nums;
      }

      j = j - 1;
      std::reverse(begin, nums.end());
      int i = len - 1;
      while (i > j && nums[i] < nums[j]) -- i;

      swap(nums[j], nums[i + 1]);
      return nums;
    }

    inline void swap(int &a, int &b){
      int tmp = a;
      a = b;
      b = tmp;
    }
};

#endif // LEETLINTCODE_LINTCODE_PREVIOUSPERMUTATION_CPP
