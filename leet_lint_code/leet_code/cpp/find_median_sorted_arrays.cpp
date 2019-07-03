// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 2.

#ifndef LEETLINTCODE_LINTCODE_FINDMEDIANSORTEDARRAYS_CPP
#define LEETLINTCODE_LINTCODE_FINDMEDIANSORTEDARRAYS_CPP

#include <vector>
#include <math.h>
#include <algorithm>


using namespace std;

class Solution
{
public:
    double findMedianSortedArrays(vector<int> &A, vector<int> &B)
    {
        size_t m = A.size();
        size_t n = B.size();

        if (m > n)
        {
            A.swap(B);
            size_t tmp = m;
            m = n;
            n = tmp;
        }

        int i_min = 0, i_max = m, half_len = (m + n + 1) / 2;

        while (i_min <= i_max)
        {
            int i = (i_min + i_max) / 2;
            int j = half_len - i;

            if (i < i_max && B[j - 1] > A[i])
            {
                i_min = i + 1;
            }
            else if (i > i_min && A[i - 1] > B[j])
            {
                i_max = i - 1;
            }
            else
            {
                int max_left;
                if (i == 0)
                {
                    max_left = B[j - 1];
                }
                else if (j == 0)
                {
                    max_left = A[i - 1];
                }
                else
                {
                    max_left = max(A[i - 1], B[j - 1]);
                }

                if ((m + n) % 2 == 1)
                {
                    return max_left;
                }

                int min_right;
                if (i == m)
                {
                    min_right = B[j];
                }
                else if (j == n)
                {
                    min_right = A[i];
                }
                else
                {
                    min_right = min(A[i], B[j]);
                }

                return (max_left + min_right) / 2.0;
            }
        }
        return 0.0;
    }
};

#endif LEETLINTCODE_LINTCODE_FINDMEDIANSORTEDARRAYS_CPP
