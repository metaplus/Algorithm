#pragma once
#include <functional>
#include <memory>
#include <stdexcept>
namespace searching
{
    template<typename Key, typename Value, typename Compare = std::less<Key>>
    struct binary_search_tree
    {
        struct node
        {
            Key key;
            Value value;
            size_t count;
            std::unique_ptr<node> left, right;
        };
        std::unique_ptr<node> root;
        size_t count(std::unique_ptr<node>& pnode) const
        {
            return pnode ? pnode->count : 0;
        }
        node& emplace_impl(Key& key, Value& value, std::unique_ptr<node>& pnode)
        {
            if(!pnode)
            {
                pnode = std::make_unique<node>(node{ std::move(key),std::move(value),1 });
                return *pnode;
            }
            static const Compare cmp{};
            if (!cmp(key, pnode->key) && !cmp(pnode->key, key))
            {
                pnode->value = std::move(value);
                return *pnode;
            }
            auto& last = emplace_impl(key, value, cmp(key, pnode->key) ? pnode->left : pnode->right);
            pnode->count = 1 + count(pnode->left) + count(pnode->right);
            return last;
        }
        node& emplace(Key key, Value value)
        {
            return emplace_impl(key, value, root);
        }
        Value at_impl(const Key& key, const std::unique_ptr<node>& pnode) const
        {
            if (!pnode) throw std::invalid_argument{ "no such key" };
            static const Compare cmp{};
            if (!cmp(key, pnode->key) && !cmp(pnode->key, key))
                return pnode->value;
            return at_impl(key, cmp(key, pnode->key) ? pnode->left : pnode->right);
        }
        Value at(const Key& key) const
        {
            return at_impl(key, root);
        }
        std::unique_ptr<node> delete_min_impl(std::unique_ptr<node>& pnode)
        {
            if (!pnode)
                return {};
            if (!pnode->left)
                return std::exchange(pnode, std::move(pnode->right));
            pnode->count -= 1;
            return delete_min_impl(pnode->left);
        }
        std::unique_ptr<node> erase_impl(const Key& key, std::unique_ptr<node>& pnode)
        {
            if (!pnode) throw std::invalid_argument{ "no such key" };
            static const Compare cmp{};
            if (cmp(key, pnode->key))
                return erase_impl(key, pnode->left);
            if (cmp(pnode->key, key))
                return erase_impl(key, pnode->right);
            if (!pnode->left)
                return std::exchange(pnode, std::move(pnode->right));
            if (!pnode->right)
                return std::exchange(pnode, std::move(pnode->left));
            auto rmin = delete_min_impl(pnode->right);
            rmin->count = pnode->count - 1;
            rmin->left = std::move(pnode->left);          // otherwise directly swap Key,Value
            rmin->right = std::move(pnode->right);
            return std::exchange(pnode, std::move(rmin));
        }
        std::unique_ptr<node> erase(const Key& key)
        {
            return erase_impl(key, root);
        }
    };
}