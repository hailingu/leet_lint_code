// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 5.

#ifndef LEETLINTCODE_LINTCODE_KTHLARGESTELEMENT_CPP
#define LEETLINTCODE_LINTCODE_KTHLARGESTELEMENT_CPP

#include <vector>

class KthLargestElement {
 public:
   int kthLargestElement(int n, std::vector<int> &nums) {
     quick_sort(0, (int)nums.size()-1, nums);
     return nums[nums.size() - n];
   }

   void quick_sort(int begin, int end, std::vector<int> &nums) {
     if (begin >= end) return ;
     int pivoid = nums[end];

     int i = begin, j = end - 1;
     while (i < j) {
       while (nums[i] <= pivoid && i < j) ++ i;
       while (nums[j] >= pivoid && i < j) -- j;
       swap(nums[i], nums[j]);
     }

     if (nums[i] > nums[end]) swap(nums[i], nums[end]);
     quick_sort(begin, i, nums);
     quick_sort(i + 1, end, nums);
  }

  void swap(int &a, int &b) {
    int tmp = a;
    a = b;
    b = tmp;
  }

  void quick_sort2(int begin, int end, std::vector<int> &nums) {
    if (begin >= end) return ;
    int pivoid = nums[end];

    int i = begin, j = end;
    while (i < j) {
      while (nums[i] <= pivoid && i < j) ++ i;
      nums[j] = nums[i];
      while (nums[j] >= pivoid && i < j) -- j;
      nums[i] = nums[j];
    }

    nums[j] = pivoid;
    quick_sort(begin, i - 1, nums);
    quick_sort(i + 1, end, nums);
  }
};

#endif // LEETLINTCODE_LINTCODE_DIGITCOUNTS_CPP
