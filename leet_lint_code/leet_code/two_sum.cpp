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

      for (int i = 0; i < nums.size(); ++ i) {
          if (hashmap.find(nums[i]) != hashmap.end()) {
              result.push_back(i);

              int j = hashmap[nums[i]];

              if (j < i) result.insert(result.begin(), j);
              else result.push_back();
          } else hashmap[target - nums[i]] = i;
      }

      return result;
    }
};

#endif // LEETLINTCODE_LINTCODE_APLUSB_CPP
