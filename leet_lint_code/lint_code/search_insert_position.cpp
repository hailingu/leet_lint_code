// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 60.

#ifndef LEETLINTCODE_LINTCODE_SEARCHINSERTPOSITION_CPP
#define LEETLINTCODE_LINTCODE_SEARCHINSERTPOSITION_CPP

#include <vector>

class SearchInsertPosition {
public:
  int searchInsert(std::vector<int>& nums, int target) {
    int len = (int) nums.size();
    for (int i = 0; i < len; ++ i) {
      if (nums[i] > target) return i;
      if (nums[i] == target) return i;
      if (nums[i] < target) {
        if(i + 1 == len) return i + 1;
        if(nums[i + 1] > target) return i + 1;
      }
   }
 }
};

#endif // LEETLINTCODE_LINTCODE_SEARCHINSERTPOSITION_CPP
