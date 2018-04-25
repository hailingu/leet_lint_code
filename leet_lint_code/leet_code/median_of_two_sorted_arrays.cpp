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
     if (nums1.size() > nums2.size())
       a = nums2, b = nums1;
     else
       a = nums1, b = nums2;

     int min = 0; int max = a.size();
     int i = 0;
     int max_of_left = 0;
     int min_of_right = 0;
     int half = (a.size() + b.size() + 1) / 2;
     while (min <= max) {
       i = (min + max) / 2;
       j = half - i;

       if (i < m && b[j - 1] > a[i]) min = i + 1;
       else if (i > 0 && a[i - 1] > b[j]) max = i - 1;
       else {
         if (i == 0) max_of_left = b[j - 1];
         else if (j == 0) max_of_left = a[i - 1];
         else max_of_left = b[j - 1] > a[i - 1] ? b[j - 1] : a[i - 1];

         if ((a.size() + b.size()) % 2 == 1) return max_of_left;

         if (i == m) min_of_right = b[j];
         else if (j == n) min_of_right = a[i];
         else min_of_right = b[j] < a[i] ? b[j] : a [i];

         return (max_of_left + min_of_right) / 2.0;
       }
     }
   }
};

#endif // LEETLINTCODE_LINTCODE_MEDIANOFTWOSORTEDARRAYS_H
