// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 98.
// Date: 2019.7.8

#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        if (root == NULL) {
            return true;
        }
        
        bool isValidLeft = true;
        if (root->left != NULL) {
            isValidLeft = root->val > root->left->val && isValidBSTHelp(root->left, (numeric_limits<long>::min)(), root->val);
        }
        
        bool isValidRight = true;
        if (root->right != NULL) {
            isValidRight = root->val < root->right->val && isValidBSTHelp(root->right, root->val,(numeric_limits<long>::max)());
        }
        
        return isValidLeft && isValidRight;
    }
    
    bool isValidBSTHelp(TreeNode* root, long lower, long upper) {
        if (root == NULL) {
            return true;
        }   
        
        return root->val > lower && root->val < upper && 
            isValidBSTHelp(root->left, lower, root->val) &&
            isValidBSTHelp(root->right, root->val, upper);
    }  
};