// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 74.

#ifndef LEETLINTCODE_LINTCODE_FIRSTBADVERSION_CPP
#define LEETLINTCODE_LINTCODE_FIRSTBADVERSION_CPP

class FirstBadVersion {
  public:
    int findFirstBadVersion(int n) {
      int left = 1, right = n, mid, min = n;
      if (!SVNRepo::isBadVersion(n - 1)) return n;
      while (left <= right) {
        mid = (left + right) / 2;
        if (SVNRepo::isBadVersion(mid)) {
          right = mid - 1;
          if (min > mid) min = mid;
        }
        else left = mid + 1;
      }
      return min;
    }
};

#endif // LEETLINTCODE_LINTCODE_FIRSTBADVERSION_CPP
