// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 49.

#ifndef LEETLINTCODE_LINTCODE_SORTLETTERSBYCASE_CPP
#define LEETLINTCODE_LINTCODE_SORTLETTERSBYCASE_CPP


#include <iostream>

class SortLettersbyCase {
 public:
  void sortLetters(std::string &chars) {
    quickSort2(0, (int)chars.length() - 1, chars);
  }
  
  void quickSort2(int begin, int end, std::string &chars) {
    if (begin >= end) return;
    int pivoit = chars[end];
    int i = begin, j = end;
    while (i < j) {
      while (i < j && chars[i] >= pivoit) ++ i;
      chars[j] = chars[i];
      while (i < j && chars[j] <= pivoit) -- j;
      chars[i] = chars[j];
    }
    
    chars[i] = pivoit;
    quickSort2(begin, i - 1, chars);
    quickSort2(i + 1, end, chars);
  }
};

#endif // LEETLINTCODE_LINTCODE_SORTLETTERSBYCASE_CPP
