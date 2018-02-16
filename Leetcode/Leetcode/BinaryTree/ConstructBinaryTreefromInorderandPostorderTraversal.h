#pragma once
#include <vector>

namespace leetcode
{
    namespace binary_tree
    {
        namespace construct_tree_from_inpost_order
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
                void build(TreeNode*& parent, view inv, view postv)
                {
                    auto temp = new TreeNode{ postv.back() };
                    parent = temp;
                    auto inp = std::find(inv.pos, inv.pos + inv.sz, postv.back());
                    size_t sl = inp - inv.pos;
                    size_t sr = inv.sz - 1 - sl;
                    if (sl > 0)
                        build(parent->left, { inv.pos,sl }, { postv.pos,sl });
                    if (sr > 0)
                        build(parent->right, { inp + 1,sr }, { postv.pos + sl,sr });
                }
                TreeNode * buildTree(std::vector<int>& inorder, std::vector<int>& postorder) {
                    if (inorder.empty())
                        return nullptr;
                    TreeNode* root = nullptr;
                    build(root, { inorder.data(),inorder.size() }, { postorder.data(),postorder.size() });
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
