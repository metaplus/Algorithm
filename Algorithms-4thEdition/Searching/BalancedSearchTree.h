#pragma once
#include <functional>
#include <memory>
namespace searching
{
    template<typename Key, typename Value, typename Compare = std::less<Key>>   // height < 2lgN   
    struct red_black_tree                                                       // average path length ~ 1.00lgN
    {                                                                           // assume left lean tree for 3-node
        enum color { red, black };
        enum direction { left, right };
        struct node
        {
            Key key;
            Value value;
            size_t count;
            color color;
            std::unique_ptr<node> left, right;
        };
        std::unique_ptr<node> root;
        bool is_red(const std::unique_ptr<node>& pnode) const
        {
            return pnode && pnode->color == red;
        }
        size_t count(const std::unique_ptr<node>& pnode) const
        {
            return pnode ? pnode->count : 0;
        }
        void rotate(const direction direction, std::unique_ptr<node>& pnode)
        {   // 3-element swap chain, capture 3 reference + 2 swap operations or exchange manners
            if (direction == left)
            {   
                auto& rtree = pnode->right;
                auto& rtree_ltree = pnode->right->left; 
                std::swap(pnode, rtree);
                std::swap(rtree, rtree_ltree);
                pnode->left->count = 1 + count(pnode->left->left) + count(pnode->left->right);
                pnode->count = 1 + count(pnode->left) + count(pnode->right);
            }
            else    // right
            {
                auto& ltree = pnode->left;
                auto& ltree_rtree = pnode->left->right;
                std::swap(pnode, ltree);
                std::swap(ltree, ltree_rtree);
                pnode->right->count = 1 + count(pnode->right->left) + count(pnode->right->right);
                pnode->count = 1 + count(pnode->left) + count(pnode->right);
            }
        }
        void flip(std::unique_ptr<node>& pnode)
        {
            pnode->left->color = black;
            pnode->right->color = black;
            pnode->color = red;
        }
        node& emplace_impl(Key& key, Value& value, std::unique_ptr<node>& pnode)
        {
            if(!pnode)
            {
                pnode = std::make_unique<node>(node{ std::move(key),std::move(value),1,red });
                return *pnode;
            }
            static const Compare cmp{};
            if (!cmp(key, pnode->key) && !cmp(pnode->key, key))
            {
                pnode->value = std::move(value);
                return *pnode;
            }
            auto& inserted = cmp(key, pnode->key) ? emplace_impl(key, value, pnode->left) : emplace_impl(key, value, pnode->right);
            if (!is_red(pnode->left) && is_red(pnode->right)) rotate(left, pnode);
            if (is_red(pnode->left) && is_red(pnode->left->left)) rotate(right, pnode);
            if (is_red(pnode->left) && is_red(pnode->right)) flip(pnode);
            pnode->count = 1 + count(pnode->left) + count(pnode->right);
            return inserted;
        }
        node& emplace(Key key, Value value)
        {
            auto& inserted = emplace_impl(key, value, root);
            root->count = black;
            return inserted;
        }
    };
}