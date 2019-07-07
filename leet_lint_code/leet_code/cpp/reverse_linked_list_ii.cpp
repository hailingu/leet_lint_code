// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 92.
// Date: 

#ifndef LEETLINTCODE_LINTCODE_REVERSELINKEDLISTII_CPP
#define LEETLINTCODE_LINTCODE_REVERSELINKEDLISTII_CPP

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

class ReverseLinkedListII {
 public:
   ListNode *reverseBetween(ListNode *head, int m, int n) {
     if (NULL == head) return head;
     ListNode* tmp_head = new ListNode(-1);
     ListNode* iter_head = tmp_head;
     tmp_head->next = head;

     int i = 0;
     ListNode* iter = tmp_head;
     while (i < m) {
       iter_head = iter;
       iter = iter->next;
       ++ i;
     }

     ListNode* tmp;
     ListNode* tmp_tail = iter;
     while (i <= n) {
       tmp = iter->next;
       iter->next = iter_head->next;
       iter_head->next = iter;
       iter = tmp;
       ++ i;
     }

     tmp_tail->next = tmp;
     return tmp_head->next;
   }
};

#endif // LEETLINTCODE_LINTCODE_REVERSELINKEDLISTII_CPP
