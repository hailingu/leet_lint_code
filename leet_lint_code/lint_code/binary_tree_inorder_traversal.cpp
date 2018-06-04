// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 67.

#ifndef LEETLINTCODE_LINTCODE_BINARYTREEINORDERTRAVERSAL_CPP
#define LEETLINTCODE_LINTCODE_BINARYTREEINORDERTRAVERSAL_CPP

#include <vector>

class TreeNode {
 public:
   TreeNode(int val) {
     this->val = val;
     this->left = this->right = NULL;
   }

   int val;
   TreeNode *left, *right;
};

class BinaryTreeInorderTraversal {
 public:
   std::vector<int> inorderTraversal(TreeNode* root) {
     std::vector<int> v;
     inorderTraversalHelp(root, v);
     return v;
    }

   void inorderTraversalHelp(TreeNode* root, std::vector<int> &v) {
     if (NULL != root) {
       inorderTraversalHelp(root->left, v);
       v.push_back(root->val);
       inorderTraversalHelp(root->right, v);
     } else return;
   }
};

#endif // LEETLINTCODE_LINTCODE_BINARYTREEINORDERTRAVERSAL_CPP
