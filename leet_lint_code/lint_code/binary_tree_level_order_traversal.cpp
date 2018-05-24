// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 69.

#ifndef LEETLINTCODE_LINTCODE_BINARYTREELEVELORDERTRAVERSAL_CPP
#define LEETLINTCODE_LINTCODE_BINARYTREELEVELORDERTRAVERSAL_CPP

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

class BinaryTreeLevelOrderTraversal {
 public:
   vector<vector<int>> levelOrder(TreeNode* root) {

   }
};

#endif // LEETLINTCODE_LINTCODE_BINARYTREELEVELORDERTRAVERSAL_CPP
