// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 68.

#ifndef LEETLINTCODE_LINTCODE_BINARYTREEPOSTTRAVERSAL_CPP
#define LEETLINTCODE_LINTCODE_BINARYTREEPOSTTRAVERSAL_CPP

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

class BinaryTreePostTraversal {
public:
  std::vector<int> postorderTraversal(TreeNode* root) {
      std::vector<int> v;
      postorderTraversalHelp(root, v);
      return v;
  }

  void postorderTraversalHelp(TreeNode* root, std::vector<int> &v) {
    if (NULL != root) {
      postorderTraversalHelp(root->left, v);
      postorderTraversalHelp(root->right, v);
      v.push_back(root->val);
    } else return;
  }
};

#endif // LEETLINTCODE_LINTCODE_BINARYTREEPOSTTRAVERSAL_CPP
