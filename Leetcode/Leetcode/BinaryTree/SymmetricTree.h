#pragma once
namespace leetcode
{
    namespace binary_tree
    {
        namespace symmetric_tree
        {
            struct TreeNode {
                int val;
                TreeNode *left;
                TreeNode *right;
                TreeNode(int x) : val(x), left(NULL), right(NULL) {}
            };
            class Solution {
            public:
                bool is_symmetric_iterative(TreeNode* root)
                {
                    if (!root)
                        return true;
                    if (root && !root->left && !root->right)
                        return true;
                    std::queue<TreeNode*> queue;
                    queue.push(root);
                    size_t layer_count = 0;
                    while (++layer_count && !queue.empty())
                    {
                        auto count = queue.size();
                        std::vector<TreeNode*> layer;
                        layer.reserve(count);
                        bool all_nullptr = true;
                        while (count-- != 0)
                        {
                            auto front = queue.front();
                            queue.pop();
                            layer.push_back(front);
                            if (!front)
                                continue;
                            if (all_nullptr && (front->left || front->right))
                                all_nullptr = false;
                            queue.push(front->left);
                            queue.push(front->right);
                        }
                        if (layer_count == 1)
                            continue;
                        if (layer.size() % 2 != 0)
                            return false;
                        for (auto i = 0; i != layer.size() / 2; ++i)
                        {
                            auto left = std::next(layer.cbegin(), i);
                            auto right = std::next(layer.crbegin(), i);
                            if (*left == nullptr || *right == nullptr)
                            {
                                if (*left == nullptr && *right == nullptr)
                                    continue;
                                return false;
                            }
                            if ((*left)->val != (*right)->val)
                            {
                                return false;
                            }
                        }
                        if(all_nullptr)
                            break;
                    }
                    return true;
                }
                bool isSymmetric(TreeNode* root) {
                    return is_symmetric_iterative(root);
                }
            };
        }
    }
}