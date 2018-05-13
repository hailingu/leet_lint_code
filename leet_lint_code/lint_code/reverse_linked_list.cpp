// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 34.

#ifndef LEETLINTCODE_LINTCODE_REVERSELINKEDLIST_CPP
#define LEETLINTCODE_LINTCODE_REVERSELINKEDLIST_CPP

#include <iostream>

class ListNode {
 public:
   ListNode(int val) {
     this->val = val;
     this->next = NULL;
   }

   int val;
   ListNode *next;
};

class ReverseLinkedList {
 public:
   ListNode * reverse(ListNode * head) {
     if (NULL == head) return head;
     ListNode* iter = head->next;
     head->next = NULL;
     ListNode* tmp;
     while (iter) {
       tmp = iter->next;
       iter->next = head;
       head = iter;
       iter = tmp;
     }
     return head;
   }
};

#endif // LEETLINTCODE_LINTCODE_REVERSELINKEDLIST_CPP
