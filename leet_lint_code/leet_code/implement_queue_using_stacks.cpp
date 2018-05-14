// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 232.

#ifndef LEETLINTCODE_LINTCODE_IMPLEMENTQUEUEUSINGSTACKS_CPP
#define LEETLINTCODE_LINTCODE_IMPLEMENTQUEUEUSINGSTACKS_CPP

#include <stack>

class MyQueue {
 public:
   MyQueue() {}

   void push(int element) {
     active.push(element);
   }

  int pop() {
    if (backup.empty())
      help();

    int val = backup.top();
    backup.pop();
    return val;
  }

  int peek() {
    if (backup.empty())
      help();
    return backup.top();
  }

  bool empty() {
       return active.empty() && backup.empty();
   }

  void help() {
    while (!active.empty()) {
      backup.push(active.top());
      active.pop();
    }
  }
  
  std::stack<int> active;
  std::stack<int> backup;
};

#endif // LEETLINTCODE_LINTCODE_IMPLEMENTQUEUEUSINGSTACKS_CPP
