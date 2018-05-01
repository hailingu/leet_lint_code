// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of lint code problem 7.

#ifndef LEETLINTCODE_LINTCODE_SERIALIZEANDSESERIALIZEBINARYTREE_CPP
#define LEETLINTCODE_LINTCODE_SERIALIZEANDSESERIALIZEBINARYTREE_CPP

#include <iostream>
#include <vector>
#include <math.h>

class TreeNode {
 public:
   int val;
   TreeNode *left, *right;
   TreeNode(int val) {
     this->val = val;
     this->left = this->right = NULL;
  }
};

class SerializeAndDeserializeBinaryTree {
 public:
   std::string serialize(TreeNode * root) {
     if (NULL == root) return "";
     std::string s = "";
     TreeNode* iter;
     std::vector<TreeNode*> queue;
     queue.push_back(root);
     while (!queue.empty()) {
       iter = queue[0];
       queue.erase(queue.begin());
       if (NULL != iter) {
         queue.push_back(iter->left);
         queue.push_back(iter->right);
        }
        if (NULL == iter) s += ",#";
        else s =  s + "," + std::to_string(iter->val);
      }
      return s.substr(1);
    }

    TreeNode * deserialize(std::string &data) {
      size_t len = data.length();
      if (0 == len) return NULL;
      std::vector<std::string> strs = split(data, ",");
      TreeNode* root = new TreeNode(stoi(strs[0]));
      std::vector<TreeNode*> queue;
      queue.push_back(root);
      int i = 1;
      while (!queue.empty()) {
        TreeNode* node = queue[0];
        queue.erase(queue.begin());
        if ("#" != strs[i] && i < strs.size()) {
          node->left = new TreeNode(stoi(strs[i]));
          queue.push_back(node->left);
        }
        ++ i;
        if ("#" != strs[i] && i < strs.size()) {
          node->right = new TreeNode(stoi(strs[i]));
          queue.push_back(node->right);
        }
        ++ i;
      }
      return root;
  }

  std::vector<std::string> split(const std::string& str, const std::string& delim) {
    std::vector<std::string> result;
    if("" == str) return result;
    char * strs = new char[str.length() + 1];
    strcpy(strs, str.c_str());

    char * d = new char[delim.length() + 1];
    strcpy(d, delim.c_str());

    char *p = strtok(strs, d);
    while (p) {
      std::string s = p;
      result.push_back(s);
      p = strtok(NULL, d);
    }
    return result;
  }
};

#endif // LEETLINTCODE_LINTCODE_SERIALIZEANDSESERIALIZEBINARYTREE_CPP
