// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 1.

#ifndef LEETLINTCODE_LINTCODE_TWOSUM_CPP
#define LEETLINTCODE_LINTCODE_TWOSUM_CPP

#include <stdio.h>
#include <vector>
#include <map>

class TwoSum {
 public:
   std::vector<int> twoSum(std::vector<int>& nums, int target) {
     std::vector<int> result;
     std::map<int, int> hashmap;

     size_t len = nums.size();
     for (int i = 0; i < len; ++ i) {
       if (hashmap.find(nums[i]) != hashmap.end()){
         int k = hashmap[nums[i]];
         result.push_back(i);
         if (k < i) result.insert(result.begin(), k);
         else result.push_back(k);
       } else hashmap[target - nums[i]] = i;
      }
      return result;
    }
};

#endif // LEETLINTCODE_LINTCODE_APLUSB_CPP
