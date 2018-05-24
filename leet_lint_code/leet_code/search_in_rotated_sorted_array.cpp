// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 33.

#ifndef LEETLINTCODE_LINTCODE_SEARCHINROTATEDSORTEDARRAY_CPP
#define LEETLINTCODE_LINTCODE_SEARCHINROTATEDSORTEDARRAY_CPP

#include <vector>

class SearchInRotatedSortedArray {
 public:
   int search(std::vector<int> &A, int target) {
     return binarySearch(A, target, 0, A.size() - 1);
   }

   int binarySearch(std::vector<int> &A, int target, int begin, int end) {
     if (end < begin) return -1;
     if (A[end] >= A[begin] && target >= A[begin] && target <= A[end]) {
       return standardBinarySearch(A, target, begin, end);
     } else {
       int mid = (end + begin) / 2;
       int center = A[mid];
       if (target == center) return mid;
       int left = binarySearch(A, target, begin, mid - 1);
       if (left != -1) return left;
       int right = binarySearch(A, target, mid + 1, end);
       if (right != -1) return right;
       return -1;
     }
   }

   int standardBinarySearch(std::vector<int> &A, int target, int begin, int end) {
     if (end < begin) return -1;
     int length = end + begin;
     int center = A[length / 2];
     if (target == center) return length / 2;
     else if(target > center) return standardBinarySearch(A, target, length / 2 + 1, end);
     else return standardBinarySearch(A, target, begin, length / 2 - 1);
   }
};

#endif // LEETLINTCODE_LINTCODE_SEARCHINROTATEDSORTEDARRAY_CPP
