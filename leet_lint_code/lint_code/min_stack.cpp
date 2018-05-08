// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 12.

#ifndef LEETLINTCODE_LINTCODE_MINSTACK_CPP
#define LEETLINTCODE_LINTCODE_MINSTACK_CPP

#include <stack>

class MinStack {
public:
 std::stack<int> s;
 std::stack<int> min_values;
 int min_value;
 int MAX;

 MinStack() {
   unsigned int zero = 0;
   this->MAX = (~zero) >> 1;
   this->min_value = MAX;
 }

 void push(int number) {
   s.push(number);
   if (number <= this->min_value) {
       this->min_value = number;
       min_values.push(number);
   }
 }

 int pop() {
     int val = s.top();
     s.pop();
     if (val == this->min_value) {
         if (!min_values.empty()) min_values.pop();
         if (!min_values.empty()){
             this->min_value = min_values.top();
         } else if(!s.empty()) this->min_value = s.top();
         else this->min_value = MAX;
     }
     return val;
 }

 int min() {
   return min_value;
 }
};

#endif // LEETLINTCODE_LINTCODE_MINSTACK_CPP
