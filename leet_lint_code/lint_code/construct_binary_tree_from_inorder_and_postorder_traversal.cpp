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
   TreeNode* buildTree(std::vector<int> &inorder, std::vector<int> &postorder) {
     if (!postorder.size()) return NULL;
     int len = (int) postorder.size();
     TreeNode* root = new TreeNode(postorder[len - 1]);
     std::map<int, int> inorder_map;
     std::map<int, int> postorder_map;
     for (size_t i = 0; i < len; ++i) {
       inorder_map[inorder[i]] = i;
       postorder_map[postorder[i]] = i;
     }

     buildTreeHelp(inorder, postorder, inorder_map, postorder_map, root, 1);
     return root;
   }

   void buildTreeHelp(std::vector<int> &inorder,
                      std::vector<int> &postorder,
                      std::map<int, int> &inorder_map,
                      std::map<int, int> &postorder_map,
                      TreeNode* root, int cnt){
      if (used.size() == inorder.size()) return ;
      int root_post_index = postorder_map[root->val];
      int root_inorder_index = inorder_map[root->val];
      int i = root_post_index - 1;
      bool found_left = false, found_right = false;
      while (i >= 0) {
        if (!found_left &&inorder_map[postorder[i]] < root_inorder_index && used.find(postorder[i]) == used.end()) {
          root->left = new TreeNode(postorder[i]);
          used.insert(postorder[i]);
          found_left = true;
        }

        if (!found_right && inorder_map[postorder[i]] > root_inorder_index && used.find(postorder[i]) == used.end()) {
          root->right = new TreeNode(postorder[i]);
          used.insert(postorder[i]);
          found_right = true;
        }
        -- i;
      }

      if (root->left)
        buildTreeHelp(inorder, postorder, inorder_map, postorder_map, root->left, used);
      if (root->right)
        buildTreeHelp(inorder, postorder, inorder_map, postorder_map, root->right, used);
    }
  }
};

#endif // LEETLINTCODE_LINTCODE_CONSTRUCBINARYTREEFROMINORDERANDPOSTORDERTRAVERSAL_CPP
