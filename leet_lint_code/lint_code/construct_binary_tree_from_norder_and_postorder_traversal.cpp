// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 72.

#ifndef LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP
#define LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP

#include <vector>
#include <map>
#include <iostream>
#include <stack>

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
 public:
   TreeNode* buildTree(std::vector<int> &inorder, std::vector<int> &postorder) {
     if (!postorder.size()) return NULL;
     int len = (int) postorder.size();
     TreeNode* root = new TreeNode(postorder[len - 1]);
     std::map<int, int> inorder_map;
     std::map<int, int> postorder_map;
     std::stack<  TreeNode*> s;
     for (size_t i = 0; i < len; ++i) {
       inorder_map[inorder[i]] = i;
       postorder_map[postorder[i]] = i;
     }

     int i = len - 2, j = len - 1;
     TreeNode* iter = root;
     while (j >= 0) {
       if (j == i - 1) {
         if (inorder_map[postorder[j]] > inorder_map[postorder[i]]) {
           iter->right = new TreeNode(postorder[j]);
           if (!iter->left || !iter->right) s.push(iter);
           iter = iter->right;
           -- j;
         } else {
           iter = s.top();
           s.pop();
           i = postorder_map[iter->val];
         }
       } else if (inorder_map[postorder[j]] < inorder_map[postorder[i]]) {
         iter->left = new TreeNode(postorder[j]);
         if (!iter->left || !iter->right) s.push(iter);
         iter = iter->right;
         -- j;
       }
     }
     return root;
   }

  }
};

#endif // LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP
