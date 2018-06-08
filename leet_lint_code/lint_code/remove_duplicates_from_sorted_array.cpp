// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 100.

#ifndef LEETLINTCODE_LINTCODE_REMOVEDUPLICATESFROMSORTEDARRAY_CPP
#define LEETLINTCODE_LINTCODE_REMOVEDUPLICATESFROMSORTEDARRAY_CPP

#include <vector>

class RemoveDuplicatesFromSortedArray {
 public:
  int removeDuplicates(std::vector<int> nums) {
    int i = 0;
    int j = i + 1;
    while (i < nums.size()) {
      while (j < nums.size() && nums[j] == nums[i]) ++ j;
      if (j != i + 1) nums[++ i] = nums[j];
      else ++ i;
      if (j == nums.size()) break;
    }
    return i;
  }
};

#endif // LEETLINTCODE_LINTCODE_REMOVEDUPLICATESFROMSORTEDARRAY_CPP
