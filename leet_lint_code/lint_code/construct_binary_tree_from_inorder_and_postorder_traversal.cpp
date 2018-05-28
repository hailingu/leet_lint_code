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

    TreeNode* root = buildTreeHelp(inorder, postorder, 0, len - 1, inorder_map, postorder_map);
    return root;
  }

  TreeNode * buildTreeHelp(std::vector<int> &inorder, std::vector<int> &postorder,
                           int p_begin, int p_end,
                           std::map<int, int> &inorder_map) {

    if (p_begin > p_end) return NULL;
    TreeNode* root = new TreeNode(postorder[p_end]);
    if (p_begin == p_end) return root;
    int i_root = inorder_map[postorder[p_end]];
    int left_index = p_begin - 1;
    for (int i = p_end - 1; i >= p_begin; -- i) {
      if (inorder_map[postorder[i]] < i_root) {
        left_index = i;
        break;
      }
    }

    int right_index = p_end - 1;
    root->left = buildTreeHelp(inorder, postorder, p_begin, left_index, inorder_map);
    root->right = buildTreeHelp(inorder, postorder,  left_index + 1, right_index, inorder_map);

    return root;
  }
};

#endif // LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP
