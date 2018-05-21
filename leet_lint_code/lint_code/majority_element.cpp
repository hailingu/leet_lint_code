// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 46.

#ifndef LEETLINTCODE_LINTCODE_MAJORITYELEMENT_CPP
#define LEETLINTCODE_LINTCODE_MAJORITYELEMENT_CPP


class MajorityElement {
 public:
    int majorityNumber(vector<int> &nums) {
      int cnt = 1, majority = nums[0], i = 1, len = (int)nums.size();
      while (i < len) {
        if (majority == nums[i])
          ++ cnt;
        else {
          -- cnt;
          if (0 == cnt) {
            majority = nums[i];
            cnt = 1;
          }
        }

        ++ i;
      }
      return majority;
    }
};

#endif // LEETLINTCODE_LINTCODE_MAJORITYELEMENT_CPP
