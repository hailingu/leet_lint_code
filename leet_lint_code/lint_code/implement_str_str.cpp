// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 13.

#ifndef LEETLINTCODE_LINTCODE_IMPLEMENTSTRSTR_CPP
#define LEETLINTCODE_LINTCODE_IMPLEMENTSTRSTR_CPP

#include <string.h>

class ImplementStrStr {
 public:
   int strStr(const char *source, const char *target) {
     if (NULL == source || NULL == target) return -1;
     if (!strcmp(source, target) || !strcmp("", target)) return 0;
     int len = (int)strlen(target), source_len = (int)strlen(source);
     if (source_len < len ) return -1;
     int* next_array = next(source);
     int i = 0, j = 0;

     while (i < source_len) {
       if (source[i] == target[j]) {
         ++ i;
         ++ j;
       } else {
         if (next_array[j] < 1) ++ i;
         else j = next_array[j];
       }

       if (j == len) break;
     }

     if (j != len) i = -1;
     else i = i - len;
     return i;
   }

   int* next(const char *target) {
     int len = (int)strlen(target);
     int* next_array = new int[len];

     int j = 1, p = 0, q = 0;
     next_array[0] = -1;
     while (j < len) {
       if (1 == j) next_array[1] = 0;
       else {
         q = j - 1;
         if (target[p] == target[q]) {
           p = p + 1;
           next_array[j] = p;
         } else {
           p = 0;
           next_array[j] = p;
         }
       }
       ++ j;
     }
     return next_array;
   }
};

#endif // LEETLINTCODE_LINTCODE_IMPLEMENTSTRSTR_CPP
