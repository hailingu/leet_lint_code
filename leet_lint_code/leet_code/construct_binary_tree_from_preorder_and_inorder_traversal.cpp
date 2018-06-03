// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 105.

#ifndef LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMPREORDERANDINORDERTRAVERSAL_CPP
#define LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMPREORDERANDINORDERTRAVERSAL_CPP

#include <vector>
#include <map>
#include <iostream>

class TreeNode {
 public:
   TreeNode (int val) {
     this->val = val;
     this->left = this->right = NULL;
   }

   int val;
   TreeNode *left, *right;
};

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
 public:
  TreeNode * buildTree(std::vector<int> &preorder, std::vector<int> &inorder) {
    if (!preorder.size()) return NULL;
    int len = (int) preorder.size();
    std::map<int, int> inorder_map;
    std::map<int, int> postorder_map;
    for (int i = 0; i < len; ++i) inorder_map[inorder[i]] = i;
    TreeNode* root = buildTreeHelp(inorder, preorder, 0, len - 1, 0, inorder_map);
    return root;
  }

  TreeNode * buildTreeHelp(std::vector<int> &inorder, std::vector<int> &preorder,
                           int i_begin, int i_end, int p_begin,
                           std::map<int, int> &inorder_map) {

    if (i_begin > i_end) return NULL;
    TreeNode* root = new TreeNode(preorder[p_begin]);
    if (i_begin == i_end) return root;
    int i_root_index = inorder_map[preorder[p_begin]];
    int right_len = i_end - i_root_index;
    int len = i_end - i_begin + 1;

    root->left = buildTreeHelp(inorder, preorder, i_begin, i_root_index - 1, p_begin + 1, inorder_map);
    root->right = buildTreeHelp(inorder, preorder,  i_root_index + 1, i_end, p_begin + len - right_len, inorder_map);

    return root;
  }
};

#endif // LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMPREORDERANDINORDERTRAVERSAL_CPP
