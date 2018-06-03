// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 80.

#ifndef LEETLINTCODE_LINTCODE_MEDIAN_CPP
#define LEETLINTCODE_LINTCODE_MEDIAN_CPP

#include <vector>
#include <map>
#include <string>
#include <iostream>

class Median {
 public:
   int median(std::vector<int> &nums) {
     std::sort(nums.begin(), nums.end());
     int mid = nums.size() / 2;
     if (nums.size() % 2 == 0) -- mid;
     return nums[mid];
   }
};

#endif // LEETLINTCODE_LINTCODE_MEDIAN_CPP
