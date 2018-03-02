#pragma once
#include <string>
#include <vector>
#include <array>
namespace string
{
    inline size_t brute_force_substring_search(const std::string& pattern, const std::string& text)
    {
        size_t i, txt_len = text.size();
        size_t j, pat_len = pattern.size();
        for (i = 0, j = 0; i < txt_len && j < pat_len; i++)
        {
            if (text.at(i) == pattern.at(j)) ++j;
            else { i -= j; j = 0; }
        }
        return j == pat_len ? i - pat_len : txt_len;
    }
    struct knuth_morris_pratt
    {
        const std::string pattern;
        std::array<std::vector<size_t>, 128> dfa;
        explicit knuth_morris_pratt(const std::string& pat)
            : pattern(pat), dfa()
        {
            dfa.fill(std::vector<size_t>(pattern.size()));
            dfa.at(pat.front()).at(0) = 0;
            for (size_t x = 0, j = 1; j < pattern.size(); j++)
            {
                for (char c = 0; c <= std::numeric_limits<char>::max(); c++)
                    dfa.at(c).at(j) = dfa.at(c).at(x);
                dfa.at(pattern.at(j)).at(j) = j + 1;
                x = dfa.at(pattern.at(j)).at(x);
            }
        }
        size_t search(const std::string& text) const
        {
            size_t i = 0, j = 0;
            for (; i != text.size() && j != pattern.size(); i++)
                j = dfa.at(text.at(i)).at(j);
            return j == pattern.size() ? i - pattern.size() : text.size();
        }
    };
    struct boyer_moore
    {
        const std::string pattern;
        std::vector<int64_t> right;
        explicit boyer_moore(const std::string& pat)
            : pattern(pat), right(128, -1)
        {
            auto str_iter = pattern.cbegin();
            while (str_iter != pattern.cend()) right.at(*str_iter) = std::distance(pattern.cbegin(), str_iter++);
        }
        size_t search(const std::string& text) const
        {
            const auto txt_len = text.size();
            const auto pat_len = pattern.size();
            size_t skip = 0;
            for (size_t i = 0; i < txt_len - pat_len; i += skip)
            {
                skip = 0;
                for (auto j = pat_len - 1; j >= 0; j--)
                {
                    if (pattern.at(j) != text.at(i + j))
                    {
                        skip = j - right.at(text.at(i + j));
                        if (skip < 1) skip = 1;
                        break;
                    }
                }
                if (skip == 0) return i;
            }
            return txt_len;
        }
    };
    struct rabin_karp
    {
        const std::string pattern;
        int64_t pat_hash;
        const int64_t prime;
        const int r = 128;
        int64_t rm;
        int64_t hash(const std::string& key, const size_t len) const
        {
            int64_t h = 0;
            for (auto j = 0; j < len; j++)
                h = (r*h + key.at(j)) % prime;
            return h;
        }
        bool check(size_t i) const          // Monte Carlo
        {                                   // for Las Vegas, check pat vs txt(i..i-pat_len+1)
            return true;
        }
        explicit rabin_karp(const std::string& pat)
            : pattern(pat), prime(997)
        {
            rm = 1;
            for (auto i = 1; i <= pat.size() - 1; i++)
                rm = (r*rm) % prime;
            pat_hash = hash(pattern, pattern.size());
        }
        size_t search(const std::string& text) const
        {
            auto txt_hash = hash(text, pattern.size());
            if (pat_hash == txt_hash && check(0)) return 0;
            for (auto i = pattern.size(); i < text.size(); i++)
            {
                txt_hash = (txt_hash + prime - rm * text.at(i - pattern.size()) % prime) % prime;
                txt_hash = (txt_hash*r + text.at(i)) % prime;
                if (pat_hash == txt_hash && check(i - pattern.size() + 1))
                    return i - pattern.size() + 1;
            }
            return text.size();
        }
    };
}