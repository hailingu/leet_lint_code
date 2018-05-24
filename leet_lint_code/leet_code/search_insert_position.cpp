// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 35.

#ifndef LEETLINTCODE_LINTCODE_SEARCHINSERTPOSITION_CPP
#define LEETLINTCODE_LINTCODE_SEARCHINSERTPOSITION_CPP

#include <vector>

class SearchInsertPosition {
 public:
   int searchInsert(vector<int>& nums, int target) {
    return binary_search(nums, target, 0, nums.size() - 1);
  }

  int binary_search(std::vector<int> &matrix, int target, int begin, int end){
    int length = end + begin;
    int center = matrix[length / 2];

    if (end - begin == 1) {
        if (target > matrix[end]) return end + 1;
        else if (target == matrix[end]) return end;
        else if (target > matrix[begin]) return begin + 1;
        else return begin;
    } else if (end - begin == 0) {
        if (target > matrix[end]) return end + 1;
        else return end;
    }

    if (target == center) return length / 2;
    if(target > center) return binary_search(matrix, target, length / 2 + 1, end);
    else return binary_search(matrix, target, begin, length / 2 - 1);
  }
};

#endif // LEETLINTCODE_LINTCODE_SEARCHINSERTPOSITION_CPP
