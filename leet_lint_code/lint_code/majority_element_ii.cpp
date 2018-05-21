// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 47.

#ifndef LEETLINTCODE_LINTCODE_MAJORITYELEMENTII_CPP
#define LEETLINTCODE_LINTCODE_MAJORITYELEMENTII_CPP

#include <vector>
#include <iostream>

class SD {
 public:
  SD() {}
  SD(int value) {
    this->value = value;
    this->cnt = 1;
  }

  int value;
  int cnt;
};

class MajorityElementII {
 public:
  int majorityNumber(std::vector<int> &nums) {
    int len = (int)nums.size();
    if (2 >= len) return -1;

    std::vector<SD> v;

    int i = 1;
    v.push_back(SD(nums[0]));
    int sub_cnt = 0;

    while (i < len) {
      SD* tmp = find(v, nums[i]);
      if (NULL != tmp) {
        ++ tmp->cnt;
      } else if (v.size() < 3) {
        v.push_back(SD(nums[i]));
      } else {
        ++ sub_cnt;
        for (int j = 0; j < 3; ++ j) {
          -- v[j].cnt;
          if (v[j].cnt == 0) {
            v[j] = SD(nums[i]);
            for (size_t k = 0; k < j;  ++ k) {
              v[k].cnt += sub_cnt;
            }
            sub_cnt = 0;
          }
        }
      }
      ++ i;
    }

    int majority = v[0].value;
    int tmp = v[0].cnt;
    for (int i = 1; i < 3; ++ i) {
      if (tmp < v[i].cnt) {
        tmp = v[i].cnt;
        majority = v[i].value;
      }
    }

    return majority;
  }

  SD* find( std::vector<SD> &v, int value) {
    int len = (int)v.size();
    for (int i = 0; i < len; ++ i) {
      if (value == v[i].value) return &v[i];
    }
    return NULL;
  }
};

#endif // LEETLINTCODE_LINTCODE_MAJORITYELEMENTII_CPP
