// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 9.

#ifndef LEETLINTCODE_LINTCODE_FIZZBUZZ_CPP
#define LEETLINTCODE_LINTCODE_FIZZBUZZ_CPP

#include <vector>
#include <iostream>
#include <string>

class FizzBuzz {
 public:
   std::vector<std::string> fizzBuzz(int n) {
     std::vector<std::string> result;
     int i = 1;
     while (i <= n) {
      if (i % 3 == 0 && i % 5 == 0)
        result.push_back("fizz buzz");
      else if (i % 3 == 0)
        result.push_back("fizz");
      else if (i % 5 == 0)
        result.push_back("buzz");
      else
        result.push_back(to_string(i));
        ++ i;
     }
     return result;
   }
};

#endif // LEETLINTCODE_LINTCODE_FIZZBUZZ_CPP
