#pragma once
#include <vector>

namespace leetcode
{
    namespace binary_tree
    {
        namespace construct_tree_from_prein_order
        {
            struct TreeNode {
                int val;
                TreeNode *left;
                TreeNode *right;
                TreeNode(int x) : val(x), left(NULL), right(NULL) {}
            };
            class Solution {
            public:
                struct view
                {
                    int* pos;
                    size_t sz;
                    int front() { return pos[0]; }
                    int back() { return pos[sz - 1]; }
                    bool empty() { return sz != 0; }
                    int size() { return sz; }
                };
                void build(TreeNode*& parent, view prev, view inv)
                {
                    auto temp = new TreeNode{ prev.front() };
                    parent = temp;
                    auto inp = std::find(inv.pos, inv.pos + inv.sz, prev.front());
                    size_t sl = inp - inv.pos;
                    size_t sr = inv.sz - 1 - sl;
                    if (sl > 0)
                        build(parent->left, { prev.pos + 1,sl }, { inv.pos,sl });
                    if (sr > 0)
                        build(parent->right, { prev.pos + sl + 1,sr }, { inp + 1,sr });
                }
                TreeNode* buildTree(std::vector<int>& preorder, std::vector<int>& inorder) {
                    if (inorder.empty())
                        return nullptr;
                    TreeNode* root = nullptr;
                    build(root, { preorder.data(),preorder.size() }, { inorder.data(),inorder.size() });
                    return root;
                }
            };
            void test()
            {
                std::vector<int> v1{ 9,3,15,20,7 };
                std::vector<int> v2{ 9,15,7,20,3 };
                auto result = Solution{}.buildTree(v1, v2);
            }
        }
    }
}
