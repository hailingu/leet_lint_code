// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 64.

#ifndef LEETLINTCODE_LINTCODE_MERGESORTEDARRAY_CPP
#define LEETLINTCODE_LINTCODE_MERGESORTEDARRAY_CPP

#include <stdio.h>

class MergeSortedArray {
 public:
    void mergeSortedArray(int A[], int m, int B[], int n) {
      int i = m - 1, j = n - 1, k = m + n - 1;
      while (i >= 0 & j >= 0) {
        if (A[i] < B[j]) A[k--] = B[j--];
        else A[k--] = A[i--];
      }

      while (j >= 0) A[k--] = B[j--];
    }
};

#endif // LEETLINTCODE_LINTCODE_MERGESORTEDARRAY_CPP
