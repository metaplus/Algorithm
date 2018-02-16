#pragma once
namespace leetcode
{
    namespace binary_tree
    {
        namespace path_sum
        {
            struct TreeNode {
                int val;
                TreeNode *left;
                TreeNode *right;
                TreeNode(int x) : val(x), left(NULL), right(NULL) {}
            };
            class Solution {
            public:
                bool is_root = true;
                bool hasPathSum(TreeNode* root, int sum) {
                    if (!root)
                        return false;
                    if (root->val == sum && !root->left && !root->right) 
                        return true;
                    return
                        hasPathSum(root->left, sum - root->val) || hasPathSum(root->right, sum - root->val);
                }
            };
        }
    }
}