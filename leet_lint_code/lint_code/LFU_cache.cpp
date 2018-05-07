// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 24.

#ifndef LEETLINTCODE_LINTCODE_LFUCACHE_CPP
#define LEETLINTCODE_LINTCODE_LFUCACHE_CPP

#include <iostream>
#include <map>

class Node {
 public:
   Node(int key, int value, int sid) {
     this->key = key;
     this->value = value;
     this->sid = sid;
     this->next = NULL;
     this->prev = NULL;
     this->count = 1;
   }

   Node* next;
   Node* prev;
   int count;
   int sid;
   int key;
   int value;
};


class LFUCache {
 public:
   LFUCache(int capacity) {
     this->capacity = capacity;
     this->head = new Node(-1, -1, -1);
     this->tail = new Node(-1, -1, -1);
     this->head->next = this->tail;
     this->tail->prev = this->head;
   }

   void set(int key, int value) {
     if (key_to_node.find(key) != key_to_node.end()) {
       key_to_node[key]->sid = sid ++;
       ++ key_to_node[key]->count;
       key_to_node[key]->value = value;
     } else if (this->key_to_node.size() == this->capacity){
       key_to_node.erase(key_to_node.find(this->head->next->key));
       this->head->next->key = key;
       this->head->next->value = value;
       this->head->next->sid = sid ++ ;
       this->head->next->count = 1;
       key_to_node[key] = this->head->next;
     } else {
       Node* tmp = new Node(key, value, sid ++);
       this->head->next->prev = tmp;
       tmp->next = head->next;
       this->head->next = tmp;
       tmp->prev = this->head;
       key_to_node[key] = tmp;
     }
     update(key_to_node[key]);
   }

   void update(Node* node) {
     Node* iter = node->next;
     while (iter != this->tail) {
       if ((node->count == iter->count && node->sid > iter->sid) ||
            node->count > iter->count ) {
         iter = iter->next;
       } else break;
     }

     node->prev->next = node->next;
     node->next->prev = node->prev;
     iter->prev->next = node;
     node->next = iter;
     node->prev = iter->prev;
     iter->prev =  node;
   }

   int get(int key) {
     if (key_to_node.find(key) != key_to_node.end()) {
       key_to_node[key]->count ++;
       key_to_node[key]->sid = sid ++;
       update(key_to_node[key]);
       return key_to_node[key]->value;
     }
     return -1;
   }

   int capacity;
   int sid;
   Node* head;
   Node* tail;
   std::map<int, Node*> key_to_node;
};

#endif // LEETLINTCODE_LINTCODE_LFUCACHE_CPP
