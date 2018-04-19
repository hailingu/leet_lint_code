// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 2.

#ifndef LEETLINTCODE_LINTCODE_ADDTWONUMBERS_CPP
#define LEETLINTCODE_LINTCODE_ADDTWONUMBERS_CPP

//class Solution {
// public:
//   ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
//    struct ListNode* l1_iter = l1;
//    struct ListNode* l2_iter = l2;
//    struct ListNode* tail = NULL;
//
//    if (!l1_iter) return l2_iter;
//    if (!l2_iter) return l1_iter;
//
//    int carry = 0;
//
//    while (l1_iter) {
//      if (l2_iter) l1_iter->val += (l2_iter->val + carry);
//      else l1_iter->val += carry;
//
//      carry = l1_iter->val / 10;
//      l1_iter->val %= 10;
//
//      if (!l1_iter->next) {
//        if (l2_iter && l2_iter->next) {
//          l1_iter->next = l2_iter->next;
//          l2_iter = NULL;
//        } else tail = l1_iter;
//      }
//
//      l1_iter = l1_iter->next;
//      if (l2_iter) l2_iter = l2_iter->next;
//    }
//
//    if (carry) tail->next = new ListNode(carry);
//    return l1;
//  }
//};

#endif // LEETLINTCODE_LINTCODE_ADDTWONUMBERS_CPP
