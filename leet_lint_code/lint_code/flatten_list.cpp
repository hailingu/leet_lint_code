// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 22.

#ifndef LEETLINTCODE_LINTCODE_FLATTENLIST_CPP
#define LEETLINTCODE_LINTCODE_FLATTENLIST_CPP

#include <vector>

/**
 *  This is the interface that allows for creating nested lists.
 *  You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */

class FlattenList {
 public:
   std::vector<int> flatten(std::vector<NestedInteger> &nestedList) {

   }
};

#endif // LEETLINTCODE_LINTCODE_FLATTENLIST_CPP
