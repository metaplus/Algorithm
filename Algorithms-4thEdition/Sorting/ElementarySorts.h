#pragma once
#include <algorithm>
#include <vector>

namespace sorting
{
    struct selection_sort
    {
        template<typename ForwardIter>
        void operator()(ForwardIter itbeg, ForwardIter itend){
            std::transform(itbeg, itend, itbeg, [=, itcur = itbeg](typename ForwardIter::value_type v) mutable
            {
                auto itmax = std::max_element(itcur, itend);
                std::iter_swap(itcur, itmax);
                std::advance(itcur, 1);
                return v;
            });
            
        }
    };
    
}                                                             