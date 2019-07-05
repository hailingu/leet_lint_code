// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 206.
// Date: 2019.7.5

#ifndef LEETLINTCODE_LINTCODE_REVERSELINKEDLIST_CPP
#define LEETLINTCODE_LINTCODE_REVERSELINKEDLIST_CPP

#include <iostream>

using namespace std;

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
   ListNode * reverseList(ListNode * head) {
     if (NULL == head || NULL == head->next) return head;
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

#endif // #endif // LEETLINTCODE_LINTCODE_REVERSELINKEDLIST_CPP
