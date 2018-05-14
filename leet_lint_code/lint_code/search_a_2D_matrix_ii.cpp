// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 38.

#ifndef LEETLINTCODE_LINTCODE_SEARCHA2DMATRIXII_CPP
#define LEETLINTCODE_LINTCODE_SEARCHA2DMATRIXII_CPP

#include <vector>

class SearchA2DMatrixII {
 public:
   int searchMatrix(vector<vector<int>> &matrix, int target) {
     int cnt = 0;
     int begin = 0, end = 0, i = 0;
     while (i < matrix.size()) {
       begin = matrix[i][0];
       end = matrix[i][matrix[i].size()-1];
       if (target == begin || target == end) ++ cnt;
       else if (target > begin || target < end) {
         if (binary_search(matrix[i], target, 0, matrix[i].size()-1)) ++ cnt;
       } else if (begin > target) break;
       ++ i;
     }
     return cnt;
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

#endif // LEETLINTCODE_LINTCODE_SEARCHA2DMATRIXII_CPP
