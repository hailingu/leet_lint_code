// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 34.

#ifndef LEETLINTCODE_LINTCODE_SEARCHFORARANGE_CPP
#define LEETLINTCODE_LINTCODE_SEARCHFORARANGE_CPP

#include <vector>

class SearchForARange {
 public:
   std::vector<int> searchRange(std::vector<int> &A, int target) {
     std::vector<int> ret;
     ret.push_back(binarySearchFirst(A, target, 0, A.size() - 1));
     ret.push_back(binarySearchLast(A, target, 0, A.size() - 1));
     return ret;
   }

   int binarySearchFirst(std::vector<int> &matrix, int target, int begin, int end){
     if (end < begin) return -1;
     int length = end + begin;
     int center = matrix[length / 2];
     if (target == center) {
       int previous = binarySearchFirst(matrix, target, begin, length / 2 - 1);
       if (previous != -1) return previous;
       else return length / 2;
     } else if(target > center) return binarySearchFirst(matrix, target, length / 2 + 1, end);
     else return binarySearchFirst(matrix, target, begin, length / 2 - 1);
   }

   int binarySearchLast(std::vector<int> &matrix, int target, int begin, int end){
     if (end < begin) return -1;
     int length = end + begin;
     int center = matrix[length / 2];
     if (end < begin) return -1;
     if (target == center) {
       int last = binarySearchLast(matrix, target, length / 2 + 1, end);
       if (last != -1) return last;
       else return length / 2;
     } else if(target > center) return binarySearchLast(matrix, target, length / 2 + 1, end);
     else return binarySearchLast(matrix, target, begin, length / 2 - 1);
   }
};

#endif // LEETLINTCODE_LINTCODE_SEARCHFORARANGE_CPP
