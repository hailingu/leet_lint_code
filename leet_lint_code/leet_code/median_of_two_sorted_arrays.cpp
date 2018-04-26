// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 4.

#ifndef LEETLINTCODE_LINTCODE_MEDIANOFTWOSORTEDARRAYS_H
#define LEETLINTCODE_LINTCODE_MEDIANOFTWOSORTEDARRAYS_H

#include <vector>

class MedianOfTwoSortedArrays {
 public:
   double findMedianSortedArrays(std::vector<int>& nums1, std::vector<int>& nums2) {
     std::vector<int> a;
     std::vector<int> b;
     if (nums1.size() > nums2.size()){
       a = nums2;
       b = nums1;
     } else {
         a = nums1;
         b = nums2;
     }

     int min = 0, i = 0, j = 0;
     unsigned long max = a.size();
     int max_of_left = 0, min_of_right = 0;
     unsigned long half = (a.size() + b.size() + 1) / 2;
     while (min <= max) {
       i = (int)(min + max) / 2;
       j = (int)half - i;

       if (i < a.size() && b[j - 1] > a[i]) min = i + 1;
       else if (i > 0 && a[i - 1] > b[j]) max = i - 1;
       else {
         if (i == 0) max_of_left = b[j - 1];
         else if (j == 0) max_of_left = a[i - 1];
         else max_of_left = b[j - 1] > a[i - 1] ? b[j - 1] : a[i - 1];

         if ((a.size() + b.size()) % 2 == 1)return max_of_left;

         if (i == a.size()) min_of_right = b[j];
         else if (j == b.size()) min_of_right = a[i];
         else min_of_right = b[j] < a[i] ? b[j] : a [i];

         return (max_of_left + min_of_right) / 2.0;
       }
     }
     return -1;
   }
};

#endif // LEETLINTCODE_LINTCODE_MEDIANOFTWOSORTEDARRAYS_H
