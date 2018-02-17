#pragma once
namespace leetcode
{
    namespace binary_tree
    {
        namespace lowest_common_ancestor
        {
            struct TreeNode {
                int val;
                TreeNode *left;
                TreeNode *right;
                TreeNode(int x) : val(x), left(NULL), right(NULL) {}
            };
            class Solution {
            public:
                TreeNode * result = nullptr;
                TreeNode* gp = nullptr;
                TreeNode* gq = nullptr;
                bool compare(TreeNode* node)
                {
                    return node == gp || node == gq;
                }
                bool find_in_subtree(TreeNode* node)
                {
                    if (!node)
                        return false;
                    auto left = find_in_subtree(node->left);
                    auto right = find_in_subtree(node->right);
                    if (compare(node) && (left || right) && !result)
                    {
                        result = node;
                        return true;
                    }
                    if (left && right && !result)
                    {
                        result = node;
                        return true;
                    }
                    if (compare(node) || left || right)
                        return true;
                    return false;
                }
                TreeNode * lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
                    gp = p;
                    gq = q;
                    find_in_subtree(root);
                    return result;
                }
            };
        }
    }
}