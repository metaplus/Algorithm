#pragma once
namespace leetcode
{
    namespace binary_tree
    {
        namespace inorder_traversal
        {
            struct TreeNode {
                int val;
                TreeNode *left;
                TreeNode *right;
                TreeNode(int x) : val(x), left(NULL), right(NULL) {}
            };
            class Solution {
            public:
                std::vector<int> preorderTraversal(TreeNode* root) {
                    if (!root)
                        return {};
                    std::vector<int> result;
                    std::function<void(TreeNode* node)> preorder;
                    preorder = [&](TreeNode* node)
                    {
                        if (node->left)
                            preorder(node->left);
                        result.push_back(node->val);
                        if (node->right)
                            preorder(node->right);
                    };
                    preorder(root);
                    return result;
                }
            };
        }
    }
}