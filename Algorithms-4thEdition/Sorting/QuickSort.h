#pragma once
#include <iterator>
#include <algorithm>
namespace sorting
{
    struct quick_sort
    {   // not equivalent std::patition(itbegin, itend , [](auto val){ return val <= *itbegin; })
        template<typename BidirIter>    
        BidirIter partition(BidirIter itbeg, BidirIter itend) const
        {
            if (std::distance(itbeg, itend) < 2) return itbeg;
            auto itpivot = itbeg;
            while (true)
            {
                while (++itbeg < itend && *itbeg <= *itpivot) continue;
                while (itbeg <= --itend && *itend >= *itpivot) continue;
                if (itbeg >= itend) break;
                std::iter_swap(itbeg, itend);
            }
            std::iter_swap(itend, itpivot);
            return itend;
        }                                   // ~2NlgN compare
        template<typename BidirIter>        // worst ~N^2/2 compare
        void operator()(BidirIter itbeg, BidirIter itend) const
        {
            if (std::distance(itbeg, itend) < 2) return;
            auto itmid = partition(itbeg, itend);
            operator()(itbeg, itmid);
            operator()(itmid + 1, itend);
        }
        struct three_way
        {
            template<typename BidirIter>    // ~(2ln2)NH compare H:= Shannon entropy
            void operator()(BidirIter itbeg, BidirIter itend) const
            {
                if (std::distance(itbeg, itend) <= 1) return;
                auto pivot = *itbeg;
                auto itls = itbeg, iteq = itbeg, itgr = itend;
                while (std::distance(iteq, itgr) > 1)
                {
                    auto iter = std::next(iteq);
                    if (*iter < pivot)
                        std::iter_swap(++itls, ++iteq);
                    else if (*iter > pivot)
                        std::iter_swap(--itgr, iter);
                    else
                        ++iteq;
                }
                std::iter_swap(itbeg, itls);
                operator()(itbeg, std::next(itls));
                operator()(itgr, itend);
            }
        };
    };
}
/*STL version
template <class ForwardIt>
void quicksort(ForwardIt first, ForwardIt last)
{
    if (first == last) return;
    auto pivot = *std::next(first, std::distance(first, last) / 2);
    ForwardIt middle1 = std::partition(first, last,
        [pivot](const auto& em) { return em < pivot; });
    ForwardIt middle2 = std::partition(middle1, last,
        [pivot](const auto& em) { return !(pivot < em); });
    quicksort(first, middle1);
    quicksort(middle2, last);
}*/