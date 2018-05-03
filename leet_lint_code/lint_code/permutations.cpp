// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 15.

#ifndef LEETLINTCODE_LINTCODE_PERMUTATIONS_CPP
#define LEETLINTCODE_LINTCODE_PERMUTATIONS_CPP

#include<vector>

class Permutations {
 public:
  std::vector<std::vector<int> > permute(std::vector<int> &num) {
     std::vector<std::vector<int> > ret;
     if (0 == num.size()) {
       std::vector<int> t;
       ret.push_back(t);
       return ret;
     }
     permute_help(ret, num, (int)num.size() - 1);
     return ret;
   }

  void permute_help(std::vector<std::vector<int> >& ret, std::vector<int> &num,  int index){
    if (0 == index) {
      std::vector<int> seed;
      seed.push_back(num[index]);
      ret.push_back(seed);
      return ;
    }

    permute_help(ret, num, index - 1);

    int size = (int)ret.size();
    for (int i = 0; i < size; ++ i) {
      for(int q = 0; q < ret[i].size() + 1; ++ q){
        std::vector<int> temp = ret[i];
        temp.insert(temp.begin() + q, num[index]);
        ret.push_back(temp);
      }
    }

    for (int q = 0; q < size; ++ q) ret.erase(ret.begin());
   }
};

#endif // LEETLINTCODE_LINTCODE_PERMUTATIONS_CPP
