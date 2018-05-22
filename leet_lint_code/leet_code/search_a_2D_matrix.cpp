// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 74.

#ifndef LEETLINTCODE_LINTCODE_SEARCHA2DMATRIX_CPP
#define LEETLINTCODE_LINTCODE_SEARCHA2DMATRIX_CPP

#include <vector>

class SearchA2DMatrix {
 public:
   bool searchMatrix(std::vector<std::vector<int> > &matrix, int target) {
     if (0 == matrix.size()) return false;
     int index = binary_search(matrix, target, 0, (int)matrix.size() - 1);
     std::vector<int> inner = matrix[index];
     return binary_search(inner, target, 0, (int)inner.size() - 1);
   }

   bool binary_search(std::vector<std::vector<int> >& matrix, int target, int begin, int end){
     int length = end + begin;
     vector<int> center_v = matrix[length / 2];
     int center = center_v[0];
     if(end <= begin) return begin;
     if (target >= center && target <= center_v[center_v.size() - 1]) return length / 2;
     else if(target > center) return binary_search(matrix, target, length / 2 + 1, end);
     else return binary_search(matrix, target, begin, length / 2 - 1);
   }

   bool binary_search(std::vector<int> matrix, int target, int begin, int end){
     if (target > matrix[end]) return false;
     if (target < matrix[begin]) return false;
     int length = begin + end;

     int center = matrix[length / 2];
     if(target == center) return true;
     else if(target > center) return binary_search(matrix, target, length / 2 + 1, end);
     else return binary_search(matrix, target, begin, length / 2 - 1);
   }
};

#endif // LEETLINTCODE_LINTCODE_SEARCHA2DMATRIX_CPP
