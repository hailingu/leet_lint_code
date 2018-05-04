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
   std::vector<std::vector<int> > subsets(std::vector<int> &nums) {
     std::vector<vector<int> > ret;
     sort(nums.begin(), nums.end());
     if (0 == nums.size()) {
      std::vector<int> v;
      ret.push_back(v);
    } else subsetsHelp(nums, ret);
    return ret;
   }

   pair<int, int> subsetsHelp(std::vector<int>& s, std::vector<std::vector<int> >& save){
     int p;
     if (s.size() > 1){
         p = s[s.size()-1];
         s.pop_back();
         pair<int,int> next = subsetsHelp(s, save);
         int t_size = (int)save.size();
         if (p == next.first) {
             for (int i = next.second; i < t_size; i ++) {
                 std::vector<int> temp = save[i];
                 temp.push_back(p);
                 save.push_back(temp);
             }
             return make_pair(p, t_size);
         }

         for (int i = 0; i < t_size; i ++) {
             std::vector<int> temp = save[i];
             temp.push_back(p);
             save.push_back(temp);
         }

         return make_pair(p, t_size);
     }

     p = s[0];
     vector<int> temp;
     vector<int> empty;
     temp->push_back(p);
     save.push_back(empty);
     save.push_back(temp);
     return make_pair(p, save.size()-1);
  }
};

#endif // LEETLINTCODE_LINTCODE_SUBSETSII_CPP
