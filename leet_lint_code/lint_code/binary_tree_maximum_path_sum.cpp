// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 94.

#ifndef LEETLINTCODE_LINTCODE_BINARYTREEMAXIMUMPATHSUM_CPP
#define LEETLINTCODE_LINTCODE_BINARYTREEMAXIMUMPATHSUM_CPP

#include <string>
#include <vector>
#include <iostream>
#include <map>
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

class BinaryTreeMaximumPathSum {
 public:
   int maxPathSum(TreeNode * root) {
     std::map<TreeNode*, int> mem;
     return maxPathSumHelp(root, mem);
   }

   int maxPathSumHelp(TreeNode* root, std::map<TreeNode*, int> &mem) {
     if (NULL == root) return 0;
     int left_val = std::max(0, maxPathSumHelp2(root->left, mem));
     int right_val = std::max(0, maxPathSumHelp2(root->right, mem));
     int left_child = maxPathSumHelp(root->left, mem);
     int right_child = maxPathSumHelp(root->right, mem);
     int max = left_val + right_val + root->val;
     if (root->left != NULL) max = std::max(max, left_child);
     if (root->right != NULL) max = std::max(max, right_child);
     return max;
   }

   int maxPathSumHelp2(TreeNode* root, std::map<TreeNode*, int> &mem) {
     if (NULL == root) return 0;
     if (mem.find(root) != mem.end()) return mem[root];
     int max = 0;
     max = std::max(max, maxPathSumHelp2(root->left, mem));
     mem[root] = root->val + std::max(max, maxPathSumHelp2(root->right, mem));
     return mem[root];
   }
};

#endif // LEETLINTCODE_LINTCODE_BINARYTREEMAXIMUMPATHSUM_CPP
