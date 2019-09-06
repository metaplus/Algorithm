#pragma once
#include <functional>
#include <vector>
#include <algorithm>
#include <cassert>
namespace sorting
{
    template<typename T, typename Compare = std::less<T>>
    struct priority_queue       // insert < 1 + lgN compare
    {   //max heap              // remove maximum  < 2lgN compare
        std::vector<T> data;
        void push(T value);
        T pop();
    };
    template<typename T, typename Compare>
    void priority_queue<T, Compare>::push(T value)
    {
        Compare cmp;
        if (data.empty()) data.resize(1);
        auto index = data.size();
        data.push_back(std::move(value));
        while (1 < index && cmp(data[index / 2], data[index]))
        {
            std::swap(data[index / 2], data[index]);
            index /= 2;
        }
    }
    template <typename T, typename Compare>
    T priority_queue<T, Compare>::pop()
    {
        auto root = data[1];        //maximum root
        Compare cmp;
        std::swap(data[1], data.back());
        data.pop_back();
        size_t index = 1;
        while (index * 2 < data.size())
        {
            auto next = index * 2;
            if (next + 1 < data.size())
                next += (cmp(data[next], data[next + 1]));
            if (!cmp(data[index], data[next])) break;
            std::swap(data[next], data[index]);
            index = next;
        }
        return root;
    }
    struct heap_sort
    {
        template<typename BidirIter>
        void sink(BidirIter itbeg, BidirIter itmid, BidirIter itend) const
        {
            while (1 + 2 * std::distance(itbeg, itmid) < std::distance(itbeg, itend))
            {
                auto index = 1 + std::distance(itbeg, itmid);
                auto itnext = std::next(itbeg, 2 * index - 1);
                auto itmax = std::distance(itnext, itend) <= 1 ? itnext :
                    std::next(itnext, *itnext < *std::next(itnext));
                if (*itmid >= *itmax) break;
                std::iter_swap(itmid, itmax);
                itmid = itmax;
            }
        }
        template<typename BidirIter>
        void operator()(BidirIter itbeg, BidirIter itend) const
        {
            if (std::distance(itbeg, itend) <= 1) return;
            auto itmid = std::next(itbeg, std::distance(itbeg, itend) / 2);
            assert(std::distance(itbeg, itmid) <= std::distance(itmid, itend));
            do sink(itbeg, --itmid, itend);         // construct heap
            while (itbeg < itmid);
            do                                      // sortdown
            {
                std::iter_swap(itbeg, --itend);
                sink(itbeg, itbeg, itend);
            } while (itbeg < itend);
        }
    };
}