// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 75.

#ifndef LEETLINTCODE_LINTCODE_FINDPEAKELEMENT_CPP
#define LEETLINTCODE_LINTCODE_FINDPEAKELEMENT_CPP

#include <vector>

class FindPeakElement {
  public:
    int findPeak(std::vector<int>& A) {
      int left = 0, right = (int)A.size() - 1, mid;
      while(left <= right) {
          if (left == right) return left;
          mid = (left + right) / 2;
          if (A[mid] > A[mid + 1]) right = mid;
          else left = mid + 1;
      }
      return left;
    }
};

#endif // LEETLINTCODE_LINTCODE_FINDPEAKELEMENT_CPP
