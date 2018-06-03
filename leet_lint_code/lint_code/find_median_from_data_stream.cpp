// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 81.

#ifndef LEETLINTCODE_LINTCODE_FINDMEDIANFROMDATASTREAM_CPP
#define LEETLINTCODE_LINTCODE_FINDMEDIANFROMDATASTREAM_CPP

#include <vector>
#include <map>
#include <iostream>

static void swap(int &a, int &b) {
  int t = a;
  a = b;
  b = t;
}

class MaxHeap {
 public:
   void push(int value) {
     values.push_back(value);
     perceDown();
   }

   int top() {
     if (values.size()) return values[0];
     return -1;
   }

   void pop() {
     values.erase(values.begin());
     perceDown();
   }

   virtual void perceDown() {
     int i = (int)values.size() - 1;
     while (i > 0) {
       if (values[i / 2] < values[i]) swap(values[i / 2], values[i]);
       -- i;
     }
   }
  
  size_t size() { return values.size(); }
  
  std::vector<int> values;
};

class MinHeap: public MaxHeap {
 public:
   void perceDown() {
     int i = (int)values.size() - 1;
     while (i > 0) {
       if (values[i / 2] > values[i]) swap(values[i / 2], values[i]);
       -- i;
     }
   }
};

class FindMedianFromDataStream {
 public:
   std::vector<int> medianII(std::vector<int> &nums) {
     MaxHeap left;
     MinHeap right;
     std::vector<int> result(0);
     int len = (int)nums.size(), i = 0, median, median_index;
     while (i < len) {
       if (i % 2 == 0) {
         if (0 == left.size()) {
           right.push(nums[i]);
           median = right.top();
         } else {
           left.push(nums[i]);
           int left_max = left.top();
           left.pop();
           right.push(left_max);
         }
       } else {
         right.push(nums[i]);
         int right_min = right.top();
         right.pop();
         left.push(right_min);
       }
       
       median_index = i / 2;
       if (median_index > (int)left.size() - 1)
         median = right.top();
       else median = left.top();
       
       result.push_back(median);
       ++ i;
     }
     
     return result;
   }
};

#endif // LEETLINTCODE_LINTCODE_FINDMEDIANFROMDATASTREAM_CPP
