#pragma once
namespace leetcode
{
    namespace binary_tree
    {
        namespace count_universal_subtree
        {
            struct TreeNode {
                int val;
                TreeNode *left;
                TreeNode *right;
                TreeNode(int x) : val(x), left(NULL), right(NULL) {}
            };
            class Solution {
            public:
                size_t count = 0;
                enum uni { null, yes, no };
                std::pair<uni, int> uni_subtree(TreeNode* node)
                {
                    if (!node)
                        return { null,0 };
                    auto left = uni_subtree(node->left);
                    auto right = uni_subtree(node->right);
                    if ((left.first == null || (left.first == yes && left.second == node->val)) &&
                        (right.first == null || (right.first == yes && right.second == node->val)))
                    {
                        count += 1;
                        return { yes,node->val };
                    }
                    else { return { no,node->val }; }
                }
                int countUnivalSubtrees(TreeNode* root) {
                    uni_subtree(root);
                    return count;
                }
            };
        }
    }
}