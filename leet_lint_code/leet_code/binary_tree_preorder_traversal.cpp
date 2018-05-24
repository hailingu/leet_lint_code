// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 144.

#ifndef LEETLINTCODE_LINTCODE_BINARYTREEPREORDERTRAVERSAL_CPP
#define LEETLINTCODE_LINTCODE_BINARYTREEPREORDERTRAVERSAL_CPP

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

class BinaryTreePreorderTraversal {
 public:
  std::vector<int> preorderTraversal(TreeNode* root) {
      std::vector<int> v;
      preorderTraversalHelp(root, v);
      return v;
  }

  void preorderTraversalHelp(TreeNode* root, std::vector<int> &v) {
    if (NULL != root) v.push_back(root->val);
    else return;
    preorderTraversalHelp(root->left, v);
    preorderTraversalHelp(root->right, v);
  }
};

#endif // LEETLINTCODE_LINTCODE_BINARYTREEPREORDERTRAVERSAL_CPP
