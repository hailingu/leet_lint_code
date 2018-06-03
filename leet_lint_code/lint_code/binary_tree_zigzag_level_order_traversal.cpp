// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 71.

#ifndef LEETLINTCODE_LINTCODE_BINARYTREEZIGZAGLEVELORDERTRAVERSAL_CPP
#define LEETLINTCODE_LINTCODE_BINARYTREEZIGZAGLEVELORDERTRAVERSAL_CPP

#include <queue>
#include <vector>
#include <math.h>
#include <algorithm>

class TreeNode {
 public:
   TreeNode(int val) {
     this->val = val;
     this->left = this->right = NULL;
   }

   int val;
   TreeNode *left, *right;
};

class BinaryTreeZigzagLevelOrderTraversal {
 public:
   std::vector<std::vector<int>> zigzagLevelOrder(TreeNode * root) {
     std::vector<std::vector<int>> v;
     levelOrderHelp(root, v, 0);
     for (int i = 0; i < v.size(); ++ i) {
         if (i % 2) std::reverse(v[i].begin(), v[i].end());
     }
     return v;
   }

   void levelOrderHelp(TreeNode* root, std::vector<std::vector<int>> &v, int level) {
     if (NULL == root) return ;
     int len = (int) v.size();
     if (len - 1 < level) v.push_back(std::vector<int>());

     v[level].push_back(root->val);
     levelOrderHelp(root->left, v, level + 1);
     levelOrderHelp(root->right, v, level + 1);
   }
};

#endif // LEETLINTCODE_LINTCODE_BINARYTREEZIGZAGLEVELORDERTRAVERSAL_CPP
