// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 31.

#ifndef LEETLINTCODE_LINTCODE_NEXTPERMUTATION_CPP
#define LEETLINTCODE_LINTCODE_NEXTPERMUTATION_CPP

#include <vector>
#include <algorithm>

class Solution {
 public:
   void nextPermutation(vector<int> &nums) {
     std::vector<int> t;
     size_t len = nums.size();
     if (1 >= len) return;

     int j = len - 1;
     while (0 < j && nums[j] <= nums[j - 1]) -- j;

     if (0 == j) {
        std::vector<int>::iterator begin = nums.begin();
        std::reverse(begin, nums.end());
        return ;
     }

     int pivot = nums[j - 1];
     int i = len - 1;

     while (0 < i && nums[i] <= pivot) -- i;
     swap(nums[i], nums[j - 1]);
     std::vector<int>::iterator begin = nums.begin() + j;
     std::reverse(begin, nums.end());
     for (size_t i = 0; i < len; ++ i) t.push_back(nums[i]);
     nums = t;
    }
};

#endif // LEETLINTCODE_LINTCODE_NEXTPERMUTATION_CPP
