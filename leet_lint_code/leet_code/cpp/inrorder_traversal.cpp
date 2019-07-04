// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 94.

#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> v = vector<int>();
        inorderTraversalHelp(root, v);
        return v;
    }

    void inorderTraversalHelp(TreeNode* root, vector<int>& v) {
        if (root == NULL) {
            return ;
        } 

        inorderTraversalHelp(root->left, v);
        v.push_back(root->val);
        inorderTraversalHelp(root->right, v);
    }    
};