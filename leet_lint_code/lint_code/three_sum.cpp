// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 57.

#ifndef LEETLINTCODE_LINTCODE_THREESUM_CPP
#define LEETLINTCODE_LINTCODE_THREESUM_CPP

#include <stdio.h>
#include <vector>
#include <algorithm>
#include <map>

class ThreeSum {
 public:
   std::vector<std::vector<int> > threeSum(std::vector<int> num) {
     std::vector<std::vector<int> > ret;
     std::sort(num.begin(),num.end());
     int len = (int)num.size(), j, k;
     for(int i=0; i < len;){
       j = i + 1, k= len - 1;
       while (j < k) {
         int sum = num[i] + num[j] + num[k];
         if(sum > 0){
           while (num[k] == num[k - 1]) { -- k; }
           -- k;
         }else if(sum < 0){
           while (num[j] == num[j + 1]){ ++ j;}
           ++ j;
         }else{
           ret.push_back({num[i], num[j], num[k]});
           while(num[j] == num[j+1]){ ++j; }
           ++ j;
         }
       }
       while (num[i] == num[i + 1]) ++i;
       ++ i;
     }
     return ret;
   }
};

#endif // LEETLINTCODE_LINTCODE_THREESUM_CPP
