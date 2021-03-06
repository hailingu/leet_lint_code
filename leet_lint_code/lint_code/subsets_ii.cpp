// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 18.

#ifndef LEETLINTCODE_LINTCODE_SUBSETSII_CPP
#define LEETLINTCODE_LINTCODE_SUBSETSII_CPP

#include <iostream>
#include <vector>
#include <algorithm>

class SubsetsII {
 public:
   std::vector<std::vector<int> > subsetsWithDup(std::vector<int> &nums) {
     std::vector<vector<int> > ret;
     std::sort(nums.begin(), nums.end());
     if (0 == nums.size()) {
      ret.push_back({});
    } else subsetsHelp(nums, ret);
    return ret;
   }

   std::pair<int, int> subsetsHelp(std::vector<int>& s, std::vector<std::vector<int> >& save){
     int p;
     if (1 < s.size()){
         p = s[s.size() - 1];
         s.pop_back();
         std::pair<int,int> next = subsetsHelp(s, save);
         int t_size = (int)save.size();
         if (p == next.first) {
             for (int i = next.second; i < t_size; ++ i) {
                 std::vector<int> temp = save[i];
                 temp.push_back(p);
                 save.push_back(temp);
             }
             return make_pair(p, t_size);
         }

         for (int i = 0; i < t_size; ++ i) {
             std::vector<int> temp = save[i];
             temp.push_back(p);
             save.push_back(temp);
         }

         return std::make_pair(p, t_size);
     }

     p = s[0];

     save.push_back({});
     save.push_back({p});
     return make_pair(p, save.size() - 1);
  }
};

#endif // LEETLINTCODE_LINTCODE_SUBSETSII_CPP
