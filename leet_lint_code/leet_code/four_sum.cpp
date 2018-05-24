// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 18.

#ifndef LEETLINTCODE_LINTCODE_FOURSUM_CPP
#define LEETLINTCODE_LINTCODE_FOURSUM_CPP

#include <vector>
#include <algorithm>

class FourSum {
 public:
  std::vector<std::vector<int>> fourSum(std::vector<int> num, int target) {
    std::vector<std::vector<int> > ret;
    std::sort(num.begin(),num.end());
    int len = (int)num.size();
    for (int i = 0; i < len - 3; ++ i) {
      if (num[i] + num[len - 1] + num[len - 2] + num[len-3] < target) continue;
      std::vector<std::vector<int> > tmp = threeSum(num, target - num[i], num[i], i + 1);
      for (int j = 0; j < tmp.size(); ++ j) ret.push_back(tmp[j]);
      while(num[i] == num[i + 1]) ++ i;
    }
    return ret;
  }

  inline std::vector<std::vector<int> > threeSum(std::vector<int> &num, int target, int &val, int index) {
    std::vector<std::vector<int> > ret;
    std::sort(num.begin(),num.end());
    int len = (int)num.size(), j, k;
    for(int i = index; i < len - 2; ++ i){
      j = i + 1, k = len - 1;
      while (j < k) {
        int sum = num[i] + num[j] + num[k];
        if(sum > target){
          while (num[k] == num[k - 1]) { -- k; }
          -- k;
        }else if(sum < target){
          while (num[j] == num[j + 1]) { ++ j;}
          ++ j;
        }else{
          ret.push_back({val, num[i], num[j], num[k]});
          while (num[j] == num[j + 1]) {++j;}
          ++ j;
        }
      }
      while (num[i] == num[i + 1]) ++i;
    }
    return ret;
  }
};

#endif // LEETLINTCODE_LINTCODE_FOURSUM_CPP
