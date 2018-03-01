#pragma once
#include <limits>
#include <array>
#include <memory>
#include <numeric>
#include <vector>

namespace string
{
    template<typename Value>
    struct trie
    {
        static constexpr auto r = std::numeric_limits<char>::max() + 1; // radix 128 for [0, 127]
        struct node
        {
            std::unique_ptr<Value> val;
            std::array<std::unique_ptr<node>, r> next;
        };
        std::unique_ptr<node> root;
        const std::unique_ptr<node>& get_impl(const std::string& str, const std::unique_ptr<node>& pnode, const size_t index = 0) const
        {
            if (!pnode) return pnode;
            if (str.size() == index) return pnode;
            return get_impl(str, pnode->next.at(str.at(index)), index + 1);
        }
        Value get(const std::string& str) const
        {
            const auto& pnode = get_impl(str, root, 0);
            if (!pnode || !pnode->val) throw std::invalid_argument{ "no such string" };
            return *(pnode->val);
        }
        void put_impl(const std::string& str, std::unique_ptr<node>& pnode, const Value& val, const size_t index = 0)
        {
            if (!pnode) pnode = std::make_unique<node>();
            if (str.size() == index)
            {
                pnode->val = std::make_unique<Value>(val);
                return;
            }
            put_impl(str, pnode->next.at(str.at(index)), val, index + 1);
        }
        void put(const std::string& str, const Value& val)
        {
            put_impl(str, root, val, 0);
        }
        size_t size(const std::unique_ptr<node>& pnode) const
        {
            if (!pnode) return 0;
            const size_t is_key = pnode->val ? 1 : 0;
            return std::accumulate(pnode->next.cbegin(), pnode->next.cend(), is_key,
                [this](size_t sum, const std::unique_ptr<node>& step) { return sum + size(step); });
        }
        size_t size() const
        {
            return size(root);
        }
        void collect(const std::unique_ptr<node>& pnode, std::string& pre, std::vector<std::string>& vec) const
        {
            if (!pnode) return;
            if (pnode->val) vec.push_back(pre);
            char c = 0;
            do
            {
                pre.push_back(c);
                collect(pnode->next.at(c), pre, vec);
                pre.pop_back();
            } while (c++ <= std::numeric_limits<char>::max());
        }
        std::vector<std::string> keys_with_prefix(const std::string& pre) const
        {
            auto pre_str = pre;
            const auto& pre_node = get_impl(pre, root, 0);
            if (!pre_node) throw std::invalid_argument{ "no such prefix" };
            std::vector<std::string> result;
            collect(pre_node, pre_str, result);
            return result;
        }
        std::vector<std::string> keys() const
        {
            return keys_with_prefix("");
        }
        size_t search(const std::unique_ptr<node>& pnode, const std::string& str, const size_t index) const
        {
            if (!pnode || index > str.size()) return 0;
            return std::max(pnode->val ? index : 0, search(pnode->next.at(str.at(index)), str, index + 1));
        }
        std::string longest_prefix_of(const std::string& str) const
        {
            auto end_index = search(root, str, 0);
            return str.substr(0, end_index);
        }
    };
    template<typename Value>    // TST
    struct ternary_search_trie
    {
        struct node
        {
            char c;
            std::unique_ptr<node> left, mid, right;
            std::unique_ptr<Value> val;
        };
        std::unique_ptr<node> root;
        const std::unique_ptr<node>& get_impl(const std::unique_ptr<node>& pnode, const std::string& str, const size_t index) const
        {
            if (!pnode) throw std::invalid_argument{ "no such key" };
            if (pnode->c > str.at(index)) return get_impl(pnode->left, str, index);
            if (pnode->c < str.at(index)) return get_impl(pnode->right, str, index);
            if (index < str.size() - 1) return get_impl(pnode->mid, str, index + 1);
            return pnode;
        }
        Value get(const std::string& str) const
        {
            const auto& pnode = get_impl(root, str, 0);
            if (!pnode->val) throw std::runtime_error{ "key without value" };
            return *pnode->val;
        }
        void put_impl(std::unique_ptr<node>& pnode, const std::string& str, const Value& val, const size_t index)
        {
            if (!pnode) { pnode = std::make_unique<node>(); pnode->c = str.at(index); }
            else if (str.at(index) < pnode->c) return put_impl(pnode->left, str, val, index);
            else if (str.at(index) > pnode->c) return put_impl(pnode->right, str, val, index);
            if (index < str.size() - 1) return put_impl(pnode->mid, str, val, index + 1);
            pnode->val = std::make_unique<Value>(val);
        }
        void put(const std::string& str, const Value& val)
        {
            put_impl(root, str, val, 0);
        }
    };
}
