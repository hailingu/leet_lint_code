// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 69.

#ifndef LEETLINTCODE_LINTCODE_BINARYTREELEVELORDERTRAVERSAL_CPP
#define LEETLINTCODE_LINTCODE_BINARYTREELEVELORDERTRAVERSAL_CPP

#include <queue>
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
   std::vector<std::vector<int>> levelOrder(TreeNode* root) {
     std::vector<std::vector<int>> v;
     levelOrderHelp(root, v, 0);
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

   std::vector<std::vector<int>> levelOrder2(TreeNode* root) {
     std::queue<TreeNode*> s1;
     std::queue<TreeNode*> s2;

     std::vector<std::vector<int>> v;
     TreeNode* iter = root;
     if (NULL != iter) s1.push(iter);
     while (!s1.empty() || !s2.empty()) {
       std::vector<int> tmp;
       while(!s1.empty()) {
         iter = s1.front();
         tmp.push_back(iter->val);
         if (NULL != iter->left) s2.push(iter->left);
         if (NULL != iter->right) s2.push(iter->right);
         s1.pop();
       }

       if (!tmp.empty()) v.push_back(tmp);
       else {
         while(!s2.empty()) {
           iter = s2.front();
           tmp.push_back(iter->val);
           if (NULL != iter->left) s1.push(iter->left);
           if (NULL != iter->right) s1.push(iter->right);
           s2.pop();
         }
       }
       if (!tmp.empty()) v.push_back(tmp);
     }
     return v;
   }
};

#endif // LEETLINTCODE_LINTCODE_BINARYTREELEVELORDERTRAVERSAL_CPP
