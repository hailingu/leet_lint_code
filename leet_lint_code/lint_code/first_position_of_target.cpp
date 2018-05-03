// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 14.

#ifndef LEETLINTCODE_LINTCODE_FIRSTPOSITIONOFTARGET_CPP
#define LEETLINTCODE_LINTCODE_FIRSTPOSITIONOFTARGET_CPP

class FirstPositionOfTarget {
 public:
   int binarySearch(vector<int> &nums, int target) {
     return binarySearchHelp(nums, 0, nums.size()-1, target);
   }

   int binarySearchHelp(vector<int> &nums, int left, int right, int target) {
     if (left > right) return -1;
     if (left == right) {
        if(nums[left] == target) return left;
        else return - 1;
     }
     int len = right - left + 1;
     int mid = (left + right) / 2;
     if (target == nums[mid])
       return min(mid, binarySearchHelp(nums, left, mid - 1, target));
     if (len % 2 == 0 && target == nums[mid+1]) return mid + 1;

     if (target < nums[mid]) return binarySearchHelp(nums, left, mid - 1, target);
     else return binarySearchHelp(nums, mid + 1, right, target);
   }

   int min(int a, int b) {
       if (b == -1) return a;
       return a < b? a : b;
   }
};

#endif // LEETLINTCODE_LINTCODE_FIRSTPOSITIONOFTARGET_CPP
