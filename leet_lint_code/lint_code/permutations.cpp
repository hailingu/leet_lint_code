// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 15.

#ifndef LEETLINTCODE_LINTCODE_PERMUTATIONS_CPP
#define LEETLINTCODE_LINTCODE_PERMUTATIONS_CPP

class Permutations {
 public:
   vector<vector<int> > permute(vector<int> &num) {
     vector<vector<int> > ret;
     if (0 == num.size()) {
       vector<int> t;
       ret.push_back(t);
       return ret;
     }
     permute_help(ret, num, (int)num.size() - 1);
     return ret;
   }

  void permute_help(vector<vector<int> >& ret, vector<int> &num,  int index){
    if (0 == index) {
      vector<int> seed;
      seed.push_back(num[index]);
      ret.push_back(seed);
      return ;
    }

    permute_help(ret, num, index - 1);

    int size = (int)ret.size();
    for (int i = 0; i < size; ++ i) {
      for(int q = 0; q < ret[i].size() + 1; ++ q){
        vector<int> temp = ret[i];
        temp.insert(temp.begin() + q, num[index]);
        ret.push_back(temp);
      }
    }

    for (int q = 0; q < size; ++ q) ret.erase(ret.begin());
   }
};

#endif // LEETLINTCODE_LINTCODE_PERMUTATIONS_CPP
