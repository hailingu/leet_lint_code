// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 86.

#ifndef LEETLINTCODE_LINTCODE_BINARYTREEITERATOR_CPP
#define LEETLINTCODE_LINTCODE_BINARYTREEITERATOR_CPP

#include <queue>
#include <iostream>

class TreeNode {
 public:
   TreeNode(int val) {
     this->val = val;
     this->left = this->right = NULL;
   }

   int val;
   TreeNode *left, *right;
};

class BSTIterator {
 public:
   BSTIterator(TreeNode * root) {
     help(root);
     this->iter = queue.begin();
   }

   bool hasNext() {
     return this->iter != queue.end();
   }

   TreeNode* next() {
     TreeNode* v = *iter;
     ++ iter;
     return v;
   }

   void help(TreeNode* root) {
     if (NULL == root) return ;
     if (root->left != NULL) help(root->left);
     this->queue.push_back(root);
     if (root->right != NULL) help(root->right);
   }

   std::vector<TreeNode*> queue;
   std::vector<TreeNode*>::iterator iter;
};

#endif // LEETLINTCODE_LINTCODE_BINARYTREEITERATOR_CPP
