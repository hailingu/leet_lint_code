// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 50.


#ifndef LEETLINTCODE_LINTCODE_PRODUCTEXCLUDEITSELF_CPP
#define LEETLINTCODE_LINTCODE_PRODUCTEXCLUDEITSELF_CPP

#include <vector>

class ProductOfArrayExcludeItself {
 public:
    std::vector<long long> productExcludeItself(std::vector<int> &nums) {
      int len = (int)nums.size();
      std::vector<long long> result(len, 1);
      if (1 == len) return result;

      for (size_t i = 0; i < len; ++ i) {
        for (size_t j = 0; j < len; ++ j) {
          if (i != j) result[i] *= nums[j];
        }

      }
      return result;
    }
};


#endif // LEETLINTCODE_LINTCODE_PRODUCTEXCLUDEITSELF_CPP
