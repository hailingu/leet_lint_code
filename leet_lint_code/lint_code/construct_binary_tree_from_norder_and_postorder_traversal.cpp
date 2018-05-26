// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 72.

#ifndef LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP
#define LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP

#include <vector>
#include <map>
#include <iostream>

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
public:
  TreeNode * buildTree(std::vector<int> &inorder, std::vector<int> &postorder) {
    if (!postorder.size()) return NULL;
    int len = (int) postorder.size();
    TreeNode* root = new TreeNode(postorder[len - 1]);
    std::map<int, int> inorder_map;
    std::map<int, int> postorder_map;
    for (size_t i = 0; i < len; ++i) {
      inorder_map[inode[i]] = i;
      postorder_map[postorder[i]] = i;
    }

    int root_index = inorder_map[root->val];

    root->left = buildTreeHelp(inorder, postorder, 0, root_index - 1, inorder_map, postorder_map);
    root->right = buildTreeHelp(inorder, postorder, root_index + 1, inorder_map, postorder_map);
    return root;
  }

  TreeNode* buildTreeHelp(std::vector<int> &inorder, std::vector<int> &postorder, int begin, int end
                     std::map<int, int> inorder_map, std::map<int, int> postorder_map) {
    if (begin > end) return NULL;
    if (begin == end) return new TreeNode(inorder[begin]);



  }
};

#endif // LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP
