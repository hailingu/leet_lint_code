// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 17.

#ifndef LEETLINTCODE_LINTCODE_SUBSETS_CPP
#define LEETLINTCODE_LINTCODE_SUBSETS_CPP

#include <iostream>
#include <vector>
#include <algorithm>

class Subsets {
 public:
   std::vector<std::vector<int> > subsets(std::vector<int> &nums) {
     std::vector<std::vector<int> > ret;
     sort(nums.begin(), nums.end());
     if (0 == nums.size()) {
      vector<int> v;
      ret.push_back(v);
    } else subsetsHelp(nums, ret);
    return ret;
   }

   void subsetsHelp(std::vector<int>& s, std::vector<std::vector<int> >& save){
    int p;
    if (1 < s.size()){
        p = s[s.size() - 1];
        s.pop_back();
        subsetsHelp(s, save);
        int t_size = (int)save.size();
        for (int i = 0; i < t_size; ++ i) {
            std::vector<int> temp = save[i];
            temp.push_back(p);
            save.push_back(temp);
        }
        return ;
    }

    p = s[0];
    save.push_back({});
    save.push_back({p});
  }
};

#endif // LEETLINTCODE_LINTCODE_SUBSETS_CPP
