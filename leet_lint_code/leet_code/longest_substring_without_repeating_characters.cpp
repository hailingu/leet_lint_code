// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 3.

#ifndef LEETLINTCODE_LINTCODE_LONGESTSUBSTRINGWITHOUTREPEATINGCHARACTERS_H
#define LEETLINTCODE_LINTCODE_LONGESTSUBSTRINGWITHOUTREPEATINGCHARACTERS_H

#include <string>

class LongestSubstringWithoutRepeatingCharacters {
 public:
   int lengthOfLongestSubstring(std::string s) {
     int max_len = 0, tmp_len = 0, len = (int)s.length(), i = 0, origin = 0;
     int hash_map[258];
     memset(hash_map, -1, 258 * sizeof(int));

     while (i < len) {
       if (-1 == hash_map[s[i]] || (-1 != hash_map[s[i]] && origin > hash_map[s[i]]))
         hash_map[s[i]] = i;
       else{
         tmp_len = i - origin;
         max_len = max_len > tmp_len ? max_len : tmp_len;
         origin = hash_map[s[i]] + 1;
         hash_map[s[i]] = i;
       }
       ++ i;
     }

     tmp_len = i - origin;
     max_len = max_len > tmp_len ? max_len : tmp_len;
     return max_len;
   }
};

#endif // LONGESTSUBSTRINGWITHOUTREPEATINGCHARACTERS
