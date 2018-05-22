// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 53.

#ifndef LEETLINTCODE_LINTCODE_REVERSEWORDSINASTRING_CPP
#define LEETLINTCODE_LINTCODE_REVERSEWORDSINASTRING_CPP

#include <iostream>
#include <stack>
#include <string>

class ReverseWordsInAString {
 public:
   std::string reverseWords(std::string &s) {
     std::string tmp = "";
     s = trim(s);
     std::string delim = " ";
     std::vector<std::string> tmp_vector;
     split(s, delim, tmp_vector);
     std::stack<std::string> tmp_stack;
     for (size_t i = 0; i < tmp_vector.size(); ++ i) tmp_stack.push(tmp_vector[i]);
     while (!tmp_stack.empty()) {
       tmp = tmp + " " + tmp_stack.top();
       tmp_stack.pop();
     }
     return trim(tmp);
   }

   std::string& trim(std::string &s) {
     if (s.empty()) return s;
     s.erase(0, s.find_first_not_of(" "));
     s.erase(s.find_last_not_of(" ") + 1);
     return s;
   }

   void split(std::string& s, std::string& delim, std::vector<std::string > &ret) {
     size_t last = 0;
     size_t index = s.find_first_of(delim, last);
     while (index != std::string::npos) {
       ret.push_back(s.substr(last, index - last));
       last = index + 1;
       index = s.find_first_of(delim, last);
     }
     if (index - last > 0) ret.push_back(s.substr(last, index - last));
   }
};

#endif // LEETLINTCODE_LINTCODE_REVERSEWORDSINASTRING_CPP
