// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 30.

#ifndef LEETLINTCODE_LINTCODE_INSERTINTERVAL_CPP
#define LEETLINTCODE_LINTCODE_INSERTINTERVAL_CPP

#include <set>
#include <vector>
#include <iostream>

class Interval {
 public:
  Interval(int start, int end) {
    this->start = start;
    this->end = end;
  }
  
  int start;
  int end;
};

class InsertInterval {
public:
    std::vector<Interval> insert(std::vector<Interval> &intervals, Interval newInterval) {
      size_t len = intervals.size();
      if (0 == len) {
        intervals.push_back(newInterval);
        return intervals;
      }
      
      Interval merged(-1, -1);
      std::set<int> merged_index;
      int i = 0, replace_index = -1;
      std::vector<Interval>::iterator iter = intervals.begin();
      while (i < len) {
        Interval tmp = intervals[i];
        if (newInterval.start > tmp.end) {
          ++ i;
        } else break;
      }
      
      if (i == len) {
        intervals.push_back(newInterval);
        return intervals;
      } else if (newInterval.end < intervals[i].start) {
        intervals.insert(iter + i, newInterval);
        return intervals;
      }
      
      replace_index = i;
      
      if (newInterval.start >= intervals[i].start) merged.start = intervals[i].start;
      else merged.start = newInterval.start;
      
      while (i < len) {
        Interval tmp = intervals[i];
        if (newInterval.end >= tmp.start) {
          if (i != replace_index) merged_index.insert(i);
          ++ i;
        } else break;
      }
      
      i = i - 1;
      if (newInterval.end > intervals[i].end) {
        merged.end = newInterval.end;
      } else merged.end = intervals[i].end;
      if (i != replace_index) merged_index.insert(i);
      
      for (int j = 0; j < merged_index.size(); ++ j)
        intervals.erase(iter + replace_index + 1);
      
      intervals[replace_index] = merged;
      return intervals;
    }
};

#endif // LEETLINTCODE_LINTCODE_INSERTINTERVAL_CPP
