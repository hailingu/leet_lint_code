// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 59.

#ifndef LEETLINTCODE_LINTCODE_THREESUM_CPP
#define LEETLINTCODE_LINTCODE_THREESUM_CPP

#include <vector>
#include <algorithm>
#include <math.h>

class ThreeSumCloset {
 public:
   int threeSumClosest(std::vector<int> &num, int target) {
     unsigned int zero = 0;
     int MAX = (~zero) >> 1;
     std::sort(num.begin(),num.end());
     int len = (int)num.size(), j, k;
     int closet = MAX;
     int distance = abs(MAX - target);
     for(int i = 0; i < len - 2; ++ i){
       j = i + 1, k = len - 1;
       while (j < k) {
         int sum = num[i] + num[j] + num[k];
         int tmp_distance = abs(sum - target);
         if (tmp_distance < distance) {
           distance = tmp_distance;
           closet = sum;
         }

         if(sum > target){
           while (num[k] == num[k - 1]) { -- k; }
           -- k;
         }else if(sum < target){
           while (num[j] == num[j + 1]) { ++ j;}
           ++ j;
         }else{
           return sum;
         }
       }
       while (num[i] == num[i + 1]) ++i;
     }
     return closet;
   }
};

#endif // LEETLINTCODE_LINTCODE_THREESUM_CPP
