#pragma once
#pragma once

namespace leetcode
{
    namespace binary_tree
    {
        namespace levelorder_traversal
        {
            struct TreeNode {
                int val;
                TreeNode *left;
                TreeNode *right;
                TreeNode(int x) : val(x), left(NULL), right(NULL) {}
            };
            class Solution {
            public:
                std::vector<std::vector<int>> levelOrder(TreeNode* root) {
                    if (!root)
                        return {};
                    std::queue<TreeNode*> queue;
                    std::queue<TreeNode*> queue_next;
                    queue.push(root);
                    std::vector<std::vector<int>> result;
                    while(!queue.empty())
                    {
                        std::vector<int> level;
                        while(!queue.empty())
                        {
                            auto top = queue.front();
                            queue.pop();
                            level.push_back(top->val);
                            if (top->left)
                                queue_next.push(top->left);
                            if (top->right)
                                queue_next.push(top->right);
                        }
                        result.push_back(std::move(level));
                        queue.swap(queue_next);
                    }
                    return result;
                }
            };
        }
    }
}
