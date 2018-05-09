// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 31.

#ifndef LEETLINTCODE_LINTCODE_PARTITIONARRAY_CPP
#define LEETLINTCODE_LINTCODE_PARTITIONARRAY_CPP

#include <vector>

class PartitionArray {
 public:
  int partitionArray(std::vector<int> &nums, int k) {
    size_t len = nums.size();
    if (0 == len) return 0;
    int pivoid = k;
    int i = 0, j = len - 1;
    while (i < j) {
      while (nums[i] < pivoid && i < j) ++ i;
      while (nums[j] >= pivoid && i < j) -- j;
      swap(nums[i], nums[j]);
    }
    
    if (nums[i] < k) ++ i;
    return i;
  }
  
  inline void swap(int &a, int &b) {
    int tmp = a;
    a = b;
    b = tmp;
  }
};

#endif // LEETLINTCODE_LINTCODE_PARTITIONARRAY_CPP
