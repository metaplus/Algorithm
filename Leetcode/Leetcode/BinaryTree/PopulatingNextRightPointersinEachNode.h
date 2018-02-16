#pragma once
namespace leetcode
{
    namespace binary_tree
    {
        namespace populating_next_right_pointers_in_each_node
        {
            struct TreeLinkNode {
                int val;
                TreeLinkNode *left, *right, *next;
                TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
            };
            class Solution {
            public:
                TreeLinkNode* first;
                TreeLinkNode* last;
                size_t len;
                void connect_as_queue()
                {
                    TreeLinkNode* current = first;
                    size_t len_new = 0;
                    for (auto i = 0; i != len; ++i)
                    {
                        if(current->left)
                        {
                            last->next = current->left;
                            last = last->next;
                            len_new += 1;
                        }
                        if(current->right)
                        {
                            last->next = current->right;
                            last = last->next;
                            len_new += 1;
                        }         
                        if (i != len - 1)
                            current = current->next;
                        else
                        {
                            first = current->next;
                            current->next = nullptr;
                        }
                    }
                    std::swap(len, len_new);
                    if (len > 1)
                        connect_as_queue();
                }
                void connect(TreeLinkNode *root) {
                    if (!root || (!root->left && !root->right))
                        return;
                    first = root;
                    last = root;
                    len = 1;
                    connect_as_queue();
                }
            };
        }
    }
}