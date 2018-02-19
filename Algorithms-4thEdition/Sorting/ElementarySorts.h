#pragma once
#include <algorithm>
#include <vector>
namespace sorting
{
    struct selection_sort   // ~N^2/2 compare N exchange
    {
        template<typename ForwardIter>
        void operator()(ForwardIter itbeg, ForwardIter itend) const
        {
            for (auto iter = itbeg; iter != itend; std::advance(iter, 1))
            {
                auto itmax = std::min_element(iter, itend);
                std::iter_swap(itmax, iter);
            }
        }
    };                      // ~N^2/4 compare ~N^2/4 exchange
    struct insertion_sort   // worst ~N^2/2 compare ~N^2/2 exchange
    {                       // best Nc-1 compare 0 exchange
        template<typename ForwardIter>
        void operator()(ForwardIter itbeg, ForwardIter itend) const
        {
            for (auto iter = std::next(itbeg); iter != itend; std::advance(iter, 1))
            {
                auto itup = std::upper_bound(itbeg, iter, *iter);
                std::rotate(itup, iter, std::next(iter));
            }
        }
    };
    struct shell_sort
    {
        template<typename BidirIter>
        void operator()(BidirIter itbeg, BidirIter itend) const
        {
            auto len = std::distance(itbeg, itend);
            if (len <= 1) return;
            auto h = 1;
            while (h < len / 3) h = 3 * h + 1;
            while (h >= 1)
            {
                for (auto itr = std::next(itbeg, h); itr < itend; std::advance(itr, 1))
                    for (auto itl = itr; std::distance(itbeg, itl) >= h && *itl < *std::next(itl, -h); std::advance(itl, -h))
                        std::swap(*itl, *std::next(itl, -h));
                h /= 3;
            }
        }
    };
}                                                             