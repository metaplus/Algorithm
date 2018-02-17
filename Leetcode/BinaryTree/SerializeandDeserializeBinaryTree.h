#pragma once
namespace leetcode
{
    namespace binary_tree
    {
        namespace serialize_deserialize
        {
            struct TreeNode {
                int val;
                TreeNode *left;
                TreeNode *right;
                TreeNode(int x) : val(x), left(NULL), right(NULL) {}
            };
            class Codec {
            public:
                // Encodes a tree to a single string.
                struct chunk
                {
                    int val;
                    bool has_left;
                    bool has_right;
                    friend std::istream& operator>>(std::istream& is, chunk& ch)
                    {
                        is.read(reinterpret_cast<char*>(&ch), sizeof(chunk));
                        return is;
                    }
                    friend std::ostream& operator<<(std::ostream& os, chunk& ch)
                    {
                        os.write(reinterpret_cast<char*>(&ch), sizeof(chunk));
                        return os;
                    }
                };
                std::string serialize(TreeNode* root) {
                    if (!root)
                        return {};
                    std::queue<TreeNode*> queue;
                    queue.push(root);
                    std::stringstream ss;
                    while (!queue.empty())
                    {
                        auto front = queue.front();
                        queue.pop();
                        auto has_left = front->left != nullptr;
                        auto has_right = front->right != nullptr;
                        auto ch = chunk{ front->val,has_left,has_right };
                        ss << ch;
                        if (has_left)
                            queue.push(front->left);
                        if (has_right)
                            queue.push(front->right);
                    }
                    return ss.str();
                }
                // Decodes your encoded data to tree.
                TreeNode* deserialize(std::string data) {
                    if (data.empty())
                        return nullptr;
                    std::stringstream ss{ std::move(data) };
                    std::queue<TreeNode*> nodes;
                    TreeNode* root = nullptr;
                    nodes.push(new TreeNode{ 0 });
                    while (!nodes.empty())
                    {
                        chunk ch;
                        ss >> ch;
                        TreeNode* front = nodes.front();
                        nodes.pop();
                        TreeNode* child = nullptr;
                        front->val = ch.val;
                        if(ch.has_left)
                        {
                            child = new TreeNode{ 0 };
                            front->left = child;
                            nodes.push(child);
                        }
                        if(ch.has_right)
                        {
                            child = new TreeNode{ 0 };
                            front->right = child;
                            nodes.push(child);
                        }
                        if (!root)
                            root = front;
                    }
                    return root;
                }
            };
        }
    }
}