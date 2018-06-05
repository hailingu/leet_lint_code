// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 89.

#ifndef LEETLINTCODE_LINTCODE_KSUM_CPP
#define LEETLINTCODE_LINTCODE_KSUM_CPP

#include <vector>
#include <iostream>
#include <map>
#include <math.h>
#include <sstream>

class KSum {
public:
  int kSum(std::vector<int> &A, int k, int target) {
    std::vector<std::vector<int>> values(k + 1, std::vector<int>(target + 1, 0));
    values[0][0] = 1;
    for (auto a : A) {
      for (int kk = k; kk > 0; -- kk)
        for (int v = target; v >= a; --v)
          values[kk][v] += values[kk][v - a];
    }
     return values[k][target];
  }
  
  int kSum2(std::vector<int> &A, int k, int target) {
    std::map<int, int> m;
    return kSumHelp(A, (int)A.size() - 1, k, target, m);
  }

  int kSumHelp(std::vector<int> &A, int end,
               int k, int target, std::map<int, int> &m) {
    if (k > end + 1) return 0;
    if (0 == target && k == 0) return 1;
    if (target < A[0]) return 0;
    int k2 = (end << 13) + (k << 10) + target;
    if (m.find(k2) != m.end()) return m[k2];
    else if (target != 0 && k > 0) {
      m[k2] = kSumHelp(A, end - 1, k, target, m) + kSumHelp(A, end - 1, k - 1, target - A[end], m);
      return m[k2];
    } else return 0;
  }
};

#endif // LEETLINTCODE_LINTCODE_KSUM_CPP
