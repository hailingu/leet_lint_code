// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 39.

#ifndef LEETLINTCODE_LINTCODE_RECOVERROTATEDSORTEDARRAY_CPP
#define LEETLINTCODE_LINTCODE_RECOVERROTATEDSORTEDARRAY_CPP

#include <stdio.h>

class RecoverRotatedSortedArray {
 public:
   void recoverRotatedSortedArray(vector<int> &nums) {
     int len = (int)nums.size();
     if (len <= 1) return ;
     while (nums[0] >= nums[len - 1]) rotateOne(nums, len);
   }

   inline void rotateOne(vector<int> &nums, int len) {
     int num = nums[0];
     int j = 0;
     while (j < len - 1) {
       nums[j] = nums[j + 1];
       j ++;
     }
     nums[len - 1] = num;
   }
};

#endif // LEETLINTCODE_LINTCODE_RECOVERROTATEDSORTEDARRAY_CPP
