// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 107.

#ifndef LEETLINTCODE_LINTCODE_BINARYTREELEVELORDERTRAVERSALII_CPP
#define LEETLINTCODE_LINTCODE_BINARYTREELEVELORDERTRAVERSALII_CPP

#include <queue>
#include <vector>
#include <math.h>

class TreeNode {
 public:
   TreeNode(int val) {
     this->val = val;
     this->left = this->right = NULL;
   }

   int val;
   TreeNode *left, *right;
};

class BinaryTreeLevelOrderTraversalII {
 public:
   std::vector<std::vector<int>> levelOrderBottom(TreeNode* root) {
     std::vector<std::vector<int>> v;
     int level = 0;
     levelOrderBottomHelp(root, v, 0, level);
     return v;
   }

   void levelOrderBottomHelp(TreeNode* root, std::vector<std::vector<int>> &v, int current_level, int &level) {
     if (NULL == root) return;
     levelOrderBottomHelp(root->left, v, current_level + 1, level);
     levelOrderBottomHelp(root->right, v, current_level + 1, level);
     if (level < current_level) level = current_level;
     int index = level - current_level;
     int len = (int)v.size();
     if (len - 1 < index) {
       std::vector<int> tmp;
       v.push_back(tmp);
     }

     v[index].push_back(root->val);
     return ;
   }
};

#endif // LEETLINTCODE_LINTCODE_BINARYTREELEVELORDERTRAVERSALII_CPP
