#pragma once
#include <functional>
#include <memory>
#include <stdexcept>
namespace seaching
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
        size_t count(std::unique_ptr<node>& node) const
        {
            return node ? node->count : 0;
        }
        node& emplace_impl(Key& key, Value& value, std::unique_ptr<node>& current)
        {
            if(!current)
            {
                current = std::make_unique<node>(node{ std::move(key),std::move(value),1 });
                return *current;
            }
            static const Compare cmp{};
            if (!cmp(key, current->key) && !cmp(current->key, key))
            {
                current->value = std::move(value);
                return *current;
            }
            auto& last = emplace_impl(key, value, cmp(key, current->key) ? current->left : current->right);
            current->count = 1 + count(current->left) + count(current->right);
            return last;
        }
        node& emplace(Key key, Value value)
        {
            return emplace_impl(key, value, root);
        }
        Value at_impl(const Key& key, const std::unique_ptr<node>& current) const
        {
            if (!current) throw std::invalid_argument{ "no such key" };
            static const Compare cmp{};
            if (!cmp(key, current->key) && !cmp(current->key, key))
                return current->value;
            return at_impl(key, cmp(key, current->key) ? current->left : current->right);
        }
        Value at(const Key& key) const
        {
            return at_impl(key, root);
        }
        std::unique_ptr<node> delete_min_impl(std::unique_ptr<node>& current)
        {
            if (!current)
                return {};
            if (!current->left)
                return std::exchange(current, std::move(current->right));
            current->count -= 1;
            return delete_min_impl(current->left);
        }
        std::unique_ptr<node> erase_impl(const Key& key, std::unique_ptr<node>& current)
        {
            if (!current) throw std::invalid_argument{ "no such key" };
            static const Compare cmp{};
            if (cmp(key, current->key))
                return erase_impl(key, current->left);
            if (cmp(current->key, key))
                return erase_impl(key, current->right);
            if (!current->left)
                return std::exchange(current, std::move(current->right));
            if (!current->right)
                return std::exchange(current, std::move(current->left));
            auto rmin = delete_min_impl(current->right);
            rmin->count = current->count - 1;
            rmin->left = std::move(current->left);          // otherwise directly swap Key,Value
            rmin->right = std::move(current->right);
            return std::exchange(current, std::move(rmin));
        }
        std::unique_ptr<node> erase(const Key& key)
        {
            return erase_impl(key, root);
        }
    };
}