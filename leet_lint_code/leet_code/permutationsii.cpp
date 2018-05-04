// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 47.

#ifndef LEETLINTCODE_LINTCODE_PERMUTATIONSII_CPP
#define LEETLINTCODE_LINTCODE_PERMUTATIONSII_CPP

#include <vector>
#include <algorithm>
#include <iostream>

class PermutationsII {
 public:
   std::vector<std::vector<int> > permuteUnique(std::vector<int> &nums) {
     std::vector<std::vector<int> > ret;
     if (0 == nums.size()) {
       std::vector<int> t;
       ret.push_back(t);
       return ret;
     }

     std::sort(nums.begin(), nums.end());
     ret.push_back(nums);

     while (true) {
       std::vector<int> t = next_permutation(ret[ret.size()-1]);
       if (t.empty()) break;
       else ret.push_back(t);
     }
     return ret;
   }

   std::vector<int> next_permutation(std::vector<int> nums) {
     std::vector<int> t;
     size_t len = nums.size();
     if (1 >= len) return t;

     int j = len - 1;
     while (j > 0 && nums[j] <= nums[j - 1]) -- j;

     if (j == 0) return t;

     int pivot = nums[j - 1];
     int i = len - 1;

     while (i > 0 && nums[i] <= pivot) -- i;
     swap(nums[i], nums[j - 1]);
     std::vector<int>::iterator begin = nums.begin() + j;
     std::reverse(begin, nums.end());
     for (size_t i = 0; i < len; ++ i) t.push_back(nums[i]);
     return t;
   }

   void swap(int &a, int &b){
     int tmp = a;
     a = b;
     b = tmp;
   }

};

#endif // LEETLINTCODE_LINTCODE_PERMUTATIONSII_CPP
