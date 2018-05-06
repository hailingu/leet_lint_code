// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 20.

#ifndef LEETLINTCODE_LINTCODE_DICESSUM_CPP
#define LEETLINTCODE_LINTCODE_DICESSUM_CPP

#include <vector>
#include <iostream>
#include <map>

class DicesSum {
 public:
    std::vector<std::pair<int, double>> dicesSum(int n) {
      std::vector<std::pair<int, double>> ret;
      std::map<long long,long long> m;
      dicesSumHelp(m, n);
      double total = 0;
      for (std::map<long long,long long>::iterator iter = m.begin(); iter != m.end(); ++ iter) {
        total += iter->second;
      }

      int lower = n, upper = 6 * n + 1;
      for (int j = lower; j < upper; ++ j) {
        ret.push_back(std::make_pair(j, m[j] / total));
      }
      return ret;
    }

  void dicesSumHelp(std::map<long long,long long> &m, int n) {
    if (1 == n) {
      for (int i = 1; i < 7; ++ i)
        m[i] = 1;
      return ;
    }

    dicesSumHelp(m, n - 1);
    std::map<long long,long long> t(m);
    m.clear();

    int lower = n, upper = 6 * n + 1;
    long long tmpTotal = 0;
    for (int j = lower; j < upper; ++ j) {
      tmpTotal = 0;
      for (int k = j - 6; k < j; ++ k)
        if (t.find(k) != t.end())
          tmpTotal += t[k];
      m[j] = tmpTotal;
    }
    return ;
  }
};

#endif // LEETLINTCODE_LINTCODE_DICESSUM_CPP
