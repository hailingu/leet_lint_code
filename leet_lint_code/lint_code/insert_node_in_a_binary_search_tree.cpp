// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 85.

#ifndef LEETLINTCODE_LINTCODE_INSERTNODEINABINARYSEARCHTREE_CPP
#define LEETLINTCODE_LINTCODE_INSERTNODEINABINARYSEARCHTREE_CPP

class TreeNode {
 public:
   TreeNode(int val) {
     this->val = val;
     this->left = this->right = NULL;
   }

   int val;
   TreeNode *left, *right;
 }



class Solution {
 public:
   TreeNode * insertNode(TreeNode * root, TreeNode * node) {
     if (NULL == root) {
       root = node;
       return root;
     } else if (root->val > node->val) root->left = insertNode(root->left, node);
     else if (root->val < node->val) root->right = insertNode(root->right, node);
     return root;
   }
};

#endif // LEETLINTCODE_LINTCODE_INSERTNODEINABINARYSEARCHTREE_CPP
