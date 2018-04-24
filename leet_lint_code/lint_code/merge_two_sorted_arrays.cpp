// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 6.

#ifndef LEETLINTCODE_LINTCODE_MERGETWOSORTEDARRAYS_CPP
#define LEETLINTCODE_LINTCODE_MERGETWOSORTEDARRAYS_CPP

#include<vector>

class MergeTwoSortedArrays {
 public:
   std::vector<int> mergeSortedArray(std::vector<int> &A, std::vector<int> &B) {
     std::vector<int>::iterator a = A.begin();
     std::vector<int>::iterator b = B.begin();
     std::vector<int> v;

     while (a != A.end() && b != B.end()) {
       if (*a < *b) addToVector(v, a);
       else if (*a == *b) {
         addToVector(v, b);
         addToVector(v, a);
       } else addToVector(v, b);
    }

    if (a == A.end())
      while (b != B.end()) addToVector(v, b);

    if (b == B.end())
      while (a != A.end()) addToVector(v, a);

    return v;
  }

  void addToVector(std::vector<int> &v,
                   std::vector<int>::iterator &iter) {
    v.push_back(*iter);
    ++ iter;
  }
};

#endif // LEETLINTCODE_LINTCODE_MERGETWOSORTEDARRAYS_CPP
