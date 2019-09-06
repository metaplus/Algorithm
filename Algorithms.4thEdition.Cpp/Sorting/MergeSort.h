#pragma once
#include <functional>
#include <iterator>
#include <cassert>
#include <algorithm>
#include <vector>
namespace sorting
{
    struct merge_sort
    {                                       // std::merge R1 + R2 -> R3
        template<typename ForwardIter>      // std::inplace_merge R1 + R2 -> R1 + R2
        static void merge(ForwardIter itbeg, ForwardIter itmid, ForwardIter itend)
        {
            if (std::distance(itbeg, itend) < 2)
                return;
            std::vector<typename ForwardIter::value_type> aux_vec{ itbeg, itend };
            auto it0_end = std::next(aux_vec.begin(), std::distance(itbeg, itmid));
            auto it0 = aux_vec.begin(), it1 = it0_end;
            std::generate(itbeg, itend, [&]
            {
                if (it0 == it0_end)
                    return *it1++;
                if (it1 == aux_vec.end())
                    return *it0++;
                if (std::less_equal<void>{}(*it0, *it1))
                    return *it0++;
                else
                    return *it1++;
            });
        }
        struct top_down     // 1/2NlgN ~ NlgN compare < 6NlgN array access
        {                   // DFS
            template<typename ForwardIter>
            void operator()(ForwardIter itbeg, ForwardIter itend) const
            {
                if (std::distance(itbeg, itend) < 2)
                    return;
                auto itmid = std::next(itbeg, std::distance(itbeg, itend) / 2);
                operator()(itbeg, itmid);
                operator()(itmid, itend);
                merge(itbeg, itmid, itend);
            }
        };
        struct bottom_up    // 1/2NlgN ~ NlgN compare < 6NlgN array access
        {                   // BFS
            template<typename ForwardIter>
            void operator()(ForwardIter itbeg, ForwardIter itend) const
            {
                auto range_size = std::distance(itbeg, itend);
                if (range_size < 2)
                    return;
                for (auto stride = 1; stride < range_size; stride *= 2)
                {
                    for (auto pos = 0; pos + stride < range_size; pos += stride * 2)
                    {
                        merge(std::next(itbeg, pos), std::next(itbeg, pos + stride),
                            pos + stride * 2 < range_size ? std::next(itbeg, pos + stride * 2) : itend);
                    }
                }
            }
        };
    };
}