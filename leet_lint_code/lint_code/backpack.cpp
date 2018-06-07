// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 92.

#ifndef LEETLINTCODE_LINTCODE_BACKPACK_CPP
#define LEETLINTCODE_LINTCODE_BACKPACK_CPP

#include <string>
#include <vector>
#include <math.h>

class Backpack {
 public:
   int backPack(int m, std::vector<int> &A) {
     std::vector<int> mem(m + 1, -1);
     return backPackHelp(m, A, mem, (int)A.size() - 1);
   }

   int backPackHelp(int m, std::vector<int> &A, std::vector<int> &mem, int index) {
     if (index < 0 || m <= 0) return 0;
     if (-1 != mem[m]) return mem[m];
     if (m < A[index]) mem[m] = backPackHelp(m, A, mem, index - 1);
     else
       mem[m] = std::max(backPackHelp(m, A, mem, index - 1), backPackHelp(m - A[index], A, mem, index - 1) + A[index]);
     return mem[m];
   }
};

#endif // LEETLINTCODE_LINTCODE_BACKPACK_CPP
