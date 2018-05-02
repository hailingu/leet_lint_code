// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 11.

#ifndef LEETLINTCODE_LINTCODE_SEARCHRANGEINBINARYSEARCHTREE_CPP
#define LEETLINTCODE_LINTCODE_SEARCHRANGEINBINARYSEARCHTREE_CPP

#include <vector>
#include <alogrithm>

class TreeNode {
 public:
   int val;
   TreeNode *left, *right;
   TreeNode(int val) {
     this->val = val;
     this->left = this->right = NULL;
   }
}

class SearchRangeInBinarySearchTree {
 public:
   std::vector<int> searchRange(TreeNode* root, int k1, int k2) {
     std::vector<int> result;
     searchRangeHelp(root, k1, k2, result);
     std::sort(result.begin(), result.end());
     return result;
   }

   void searchRangeHelp(TreeNode* root, int k1, int k2, std::vector<int> &array) {
     if (NULL == root) return;
     if (root->val < k1) return searchRangeHelp(root->right, k1, k2, array);
     if (root->val > k2) return searchRangeHelp(root->left, k1, k2, array);
     array.push_back(root->val);
     searchRangeHelp(root->left, k1, k2, array);
     searchRangeHelp(root->right, k1, k2, array);
     return;
   }
};

#endif // LEETLINTCODE_LINTCODE_SEARCHRANGEINBINARYSEARCHTREE_CPP
