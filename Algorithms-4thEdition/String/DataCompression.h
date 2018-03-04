#pragma once
#include "Trie.h"
#include <queue>
#include <functional>
#include <bitset>
#include <sstream>
#include <iomanip>

namespace string
{
    struct huffman_compression
    {
        struct node
        {
            char ch;
            size_t frequence;
            std::unique_ptr<node> left, right;
            bool is_leaf() const { return !left && !right; }
            bool operator>(const node& right) const { return frequence < right.frequence; }
        };
        static constexpr size_t r = 128;
        static std::unique_ptr<node> build_trie(const std::vector<size_t> frequences)
        {
            auto ptr_great = [](const std::unique_ptr<node>& l, const std::unique_ptr<node>& r) -> bool { return *l > *r; };
            std::priority_queue<std::unique_ptr<node>, std::vector<std::unique_ptr<node>>, decltype(ptr_great)> pnode_min_heap(std::move(ptr_great));
            for (char ch = 0; ch >= 0; ++ch)
                if (frequences.at(ch) > 0) pnode_min_heap.push(std::make_unique<node>(node{ ch,frequences.at(ch),nullptr,nullptr }));
            using reference = decltype(pnode_min_heap)::reference;
            while (pnode_min_heap.size() > 1)
            {
                auto left = std::move(const_cast<reference>(pnode_min_heap.top()));  pnode_min_heap.pop();
                auto right = std::move(const_cast<reference>(pnode_min_heap.top()));  pnode_min_heap.pop();
                const auto freq_sum = left->frequence + right->frequence;
                pnode_min_heap.push(std::make_unique<node>(node{ '\0',freq_sum,std::move(left),std::move(right) }));
            }
            return std::move(const_cast<reference>(pnode_min_heap.top()));
        }
        static void build_code(std::array<std::string, r>& code_table, const std::unique_ptr<node>& pnode, const std::string str)
        {
            if (pnode->is_leaf()) { code_table.at(pnode->ch) = str; return; }
            build_code(code_table, pnode->left, str + '0');
            build_code(code_table, pnode->right, str + '1');
        }
        static std::string compress(const std::string& str) 
        {
            std::vector<size_t> frequences(r, 0);
            for (const auto ch : str) frequences.at(ch) += 1;
            const auto trie = build_trie(frequences);
            std::array<std::string, r> code_table;
            build_code(code_table, trie, "");
            std::vector<bool> compress_bits;
            for (const auto ch : str)
                std::transform(code_table.at(ch).cbegin(), code_table.at(ch).cend(),
                    std::back_inserter(compress_bits), [](const char ch) -> bool { return ch != '0'; });
            std::string compress_str((compress_bits.size() + 7) / 8, '\0');
            auto itstr = compress_str.begin();
            for (auto itbit = compress_bits.cbegin(); itbit != compress_bits.cend(); ++itbit)
            {
                const auto shift = std::distance(compress_bits.cbegin(), itbit) % 8;
                if (itbit != compress_bits.cbegin() && shift == 0) ++itstr;
                *itstr |= *itbit << shift;
            }
            return compress_str;
        }
    };
    struct lempel_ziv_welch_compression             // LZW compression
    {
        static constexpr size_t r = 128;            // number of input chars
        static constexpr size_t l = 4096;           // number of codewords = 2^12
        static constexpr size_t w = 12;             // codeword width
        static std::string compress(std::string str)
        {
            std::stringstream sstream; sstream.setf(std::ios::binary);
            //ternary_search_trie<size_t> tst;      // TODO
            trie<size_t> trie;
            for (char ch = 0; ch > 0; ++ch) trie.put(std::string{ ch }, ch);
            auto code = r + 1;                      // r is codeword for eof
            std::vector<bool> compress_bits;
            while (!str.empty())
            {
                const auto s = trie.longest_prefix_of(str);
                sstream << std::setw(w) << trie.get(s);
                const auto t = s.length();
                if (t < str.size() && code < l)
                    trie.put(str.substr(0, t + 1), code++);
                str = str.substr(t);
            }
            sstream << std::setw(w) << r;
            return sstream.str();
        }
    };
}