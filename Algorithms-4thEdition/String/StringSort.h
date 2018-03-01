#pragma once
#include <vector>
#include <algorithm>
#include <functional>
#include <cassert>

namespace string
{
    struct string_sort
    {
        // LSD radix sort, require string equal length
        static void least_significant_digit_fisrt_sort(std::vector<std::string>& strvec) 
        {
            static size_t len = 0;
            if (!len) len = strvec.front().size() - 1;
            //while (--len != std::numeric_limits<decltype(len)>::max())
            do
            {
                std::stable_sort(strvec.begin(), strvec.end(), 
                    [&](const std::string& sl, const std::string& sr) { return sl.at(len) < sr.at(len); });
            } while (len-- != 0);
        }
        // MSD sort
        static void most_significant_digit_first_sort(std::vector<std::string>& strvec) 
        {
            const auto min_char = std::numeric_limits<char>::min();
            using iterator = std::remove_reference_t<decltype(strvec)>::iterator;
            std::function<void(iterator itbeg, iterator itend, size_t)> sort;
            sort = [&](iterator itbeg, iterator itend, size_t index = 0)
            {
                std::stable_sort(itbeg, itend, [&](const std::string& sl, const std::string& sr)
                { return (index < sl.size() ? sl.at(index) : min_char) < (index < sr.size() ? sr.at(index) : min_char); });
                auto iter = std::find_if(itbeg, itend, [&](const std::string& str) { return index < str.size(); });
                while (iter != itend)
                {
                    auto iter_end = std::upper_bound(iter, itend, *iter,
                        [&](const std::string& sl, const std::string& sr)
                        { return (index < sl.size() ? sl.at(index) : min_char) < (index < sr.size() ? sr.at(index) : min_char); });
                    sort(iter, iter_end, index + 1);
                    std::swap(iter, iter_end);
                }
            };
            sort(strvec.begin(), strvec.end(), 0);
        }
        static void three_way_quick_sort(std::vector<std::string>& strvec)
        {
            using iterator = std::remove_reference_t<decltype(strvec)>::iterator;
            std::function<void(iterator itbeg, iterator itend, size_t)> sort;
            sort = [&](iterator itbeg, iterator itend, size_t index = 0)
            {
                if (std::distance(itbeg, itend) <= 1) return;
                auto iter_equal = itbeg;
                auto iter_raw = std::next(iter_equal);
                auto iter_raw_end = itend;
                const auto char_compare = [](const iterator& itl, const iterator& itr, size_t index) 
                { 
                    const auto char_min = std::numeric_limits<char>::min();;
                    return (index < itl->size() ? itl->at(index) : char_min) < (index < itr->size() ? itr->at(index) : char_min);
                };
                while (std::distance(iter_raw, iter_raw_end) > 0)
                {
                    if (char_compare(iter_raw, iter_equal, index)) std::iter_swap(iter_raw++, iter_equal++);
                    else if (char_compare(iter_equal, iter_raw, index)) std::iter_swap(iter_raw, --iter_raw_end);
                    else ++iter_raw;
                }
                assert(iter_raw == iter_raw_end);
                sort(itbeg, iter_equal, index);
                if (index < iter_equal->size()) sort(iter_equal, iter_raw, index + 1);
                sort(iter_raw_end, itend, index);
            };
            sort(strvec.begin(), strvec.end(), 0);
        }
    };
}