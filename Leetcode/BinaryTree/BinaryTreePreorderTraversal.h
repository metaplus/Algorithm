#pragma once
namespace leetcode
{
    namespace binary_tree
    {
        namespace preorder_traversal
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
                    preorder=[&](TreeNode* node)
                    {
                        result.push_back(node->val);
                        if(node->left)
                            preorder(node->left);
                        if(node->right)
                            preorder(node->right);
                    };
                    preorder(root);
                    return result;
/*                    TreeNode* current = root;
                    TreeNode* first = new TreeNode{ -1 };
                    TreeNode* last = first;
                    first->left = root;
                    std::vector<int> result;
                    while (first != nullptr)
                    {
                        result.push_back(first->val);
                        if(first->left)
                        {
                            last->right = new TreeNode{ -1 };
                            last = last->right;
                            last->left = first->left;
                        }
                        if(first->right)
                        {
                            last->right = new TreeNode{ -1 };
                            last = last->right;
                            last->left = first->right;
                        }
                        if (first == last)
                            first = nullptr;
                        else
                            first = first->right;
                    }
                    return result;*/
                }
            };
        }
    }
}