// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 5.

#ifndef LEETLINTCODE_LINTCODE_LONGESTPALINDROMICSUBSTRING_H
#define LEETLINTCODE_LINTCODE_LONGESTPALINDROMICSUBSTRING_H

#include <vector>
#include <iostream>
#include <string.h>

class LongestPalindromicSubstring {
 public:
   std::string longestPalindrome(std::string s) {
     return manacher(s);
   }

   std::string manacher(std::string s) {
     std::vector<int> p;
     std::string s_cpy = "$";
     for (int i = 0;  i < s.length(); ++ i){
       s_cpy.append("#");
       s_cpy.append(s.substr(i, 1));
     }
     s_cpy.append("#");

     for (int i = 0; i < s_cpy.length(); ++ i) p.push_back(0);

     int i = 1;
     int center = 0;
     int right_border = 0;
     while (i < s_cpy.length()) {
       if (i < right_border)
         p[i] = p[2 * center - i] < right_border - i ?
         p[2 * center - i] : right_border - i;
         else p[i] = 1;

       while (s_cpy[i - p[i]] == s_cpy[i + p[i]]) ++ p[i];
         if (right_border < i + p[i]) {
           center = i;
           right_border = i + p[i];
          }
        ++ i;
      }

      int index = 0;
      int length = 0;
      for (int i = 0; i < p.size(); ++ i) {
        if (p[i] > length) {
          index = i;
          length = p[i];
        }
      }

      std::string ret = "";
      for (int j = index - length + 1; j < index + length; ++ j)
        if (s_cpy[j] != '#') ret.append(s_cpy.substr(j, 1));

      return ret;
    }
};

#endif // LEETLINTCODE_LINTCODE_LONGESTPALINDROMICSUBSTRING_H
