// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 52.

#ifndef LEETLINTCODE_LINTCODE_NEXTPERMUTATION_CPP
#define LEETLINTCODE_LINTCODE_NEXTPERMUTATION_CPP

#include <vector>
#include <algorithm>

class NextPermutation {
 public:
   std::vector<int> nextPermutation(std::vector<int> &nums) {
     size_t len = nums.size();
     if (1 >= len) return nums;

     int j = len - 1;
     while (0 < j && nums[j] <= nums[j - 1]) -- j;

     if (0 == j) {
       std::vector<int>::iterator begin = nums.begin();
       std::reverse(begin, nums.end());
       return nums;
     }

     int pivot = nums[j - 1];
     int i = len - 1;

     while (0 < i && nums[i] <= pivot) -- i;
     swap(nums[i], nums[j - 1]);
     std::vector<int>::iterator begin = nums.begin() + j;
     std::reverse(begin, nums.end());
     return nums;
   }
};

#endif // LEETLINTCODE_LINTCODE_NEXTPERMUTATION_CPP
