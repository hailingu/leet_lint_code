// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 72.

#ifndef LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP
#define LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP

#include <vector>
#include <map>
#include <iostream>
#include <stack>

class TreeNode {
 public:
   TreeNode (int val) {
     this->val = val;
     this->left = this->right = NULL;
   }

   int val;
   TreeNode *left, *right;
};

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
 public:
   TreeNode * buildTree(std::vector<int> &inorder, std::vector<int> &postorder) {
     if (!postorder.size()) return NULL;
     int len = (int) postorder.size();
     std::map<int, int> inorder_map;
     for (int i = 0; i < len; ++i) inorder_map[inorder[i]] = i;
     TreeNode* root = buildTreeHelp(inorder, postorder, 0, len - 1, len - 1,inorder_map);
     return root;
   }

   TreeNode * buildTreeHelp(std::vector<int> &inorder, std::vector<int> &postorder,
                            int i_begin, int i_end, int p_end,
                            std::map<int, int> &inorder_map) {

     if (i_begin > i_end) return NULL;
     TreeNode* root = new TreeNode(postorder[p_end]);
     if (i_begin == i_end) return root;
     int i_root_index = inorder_map[postorder[p_end]];
     int len = i_end - i_begin + 1;
     int left_len = i_root_index - i_begin;

     root->left = buildTreeHelp(inorder, postorder, i_begin, i_root_index - 1, p_end - len + left_len,inorder_map);
     root->right = buildTreeHelp(inorder, postorder, i_root_index + 1, i_end, p_end - 1, inorder_map);
     return root;
   }
};

#endif // LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP
